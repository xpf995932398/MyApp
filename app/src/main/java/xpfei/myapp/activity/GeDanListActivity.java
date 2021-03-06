package xpfei.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.alibaba.fastjson.JSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import xpfei.myapp.R;
import xpfei.myapp.activity.base.MyBaseActivity;
import xpfei.myapp.adapter.GeDanAdapter;
import xpfei.myapp.databinding.ActivityListBinding;
import xpfei.myapp.model.GeDanInfo;
import xpfei.myapp.util.BaiduMusicApi;
import xpfei.myapp.util.ContentValue;
import xpfei.mylibrary.net.MyVolley;
import xpfei.mylibrary.utils.AppLog;
import xpfei.mylibrary.utils.CommonUtil;
import xpfei.mylibrary.view.reclyview.CustomFooterView;
import xpfei.mylibrary.view.reclyview.XRefreshView;

/**
 * Description: 歌单列表
 * Author: xpfei
 * Date:   2017/08/21
 */
public class GeDanListActivity extends MyBaseActivity {
    private String title;//标题
    private ActivityListBinding binding;
    private int page = 1;
    private GeDanAdapter adapter;
    private List<GeDanInfo> list = new ArrayList<>();
    private boolean isMore = true, isMsv = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        title = getIntent().getStringExtra(ContentValue.IntentKey.IntentKeyStr);
        onSetTitle(title);
        onSetLeft(true);
        initView();
    }

    private void initView() {
        binding.xrefreshview.setPullRefreshEnable(false);
        binding.recvclerview.setLayoutManager(new GridLayoutManager(this, 3));
        binding.xrefreshview.setPullLoadEnable(true);
        adapter = new GeDanAdapter(this, list, R.layout.item_recyclerview_gedan);
        binding.recvclerview.setAdapter(adapter);
        adapter.setCustomLoadMoreView(new CustomFooterView(this));
        binding.xrefreshview.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onLoadMore(boolean isSilence) {
                if (isMore) {
                    loadmore();
                } else {
                    binding.xrefreshview.setPullLoadEnable(false);
                    CommonUtil.showToast(GeDanListActivity.this, "已经是最后一页了！");
                }
            }
        });
        startBaseMSVReqTask(this, null);
    }

    private void loadmore() {
        isMsv = false;
        page++;
        onRequestData();
    }

    @Override
    public void onRequestData() {
        MyVolley.getInstance(this).get(BaiduMusicApi.GeDan.geDan(page, 12), new MyVolley.MyCallBack() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                int code = jsonObject.optInt(ContentValue.Json.ErrorCode);
                if (code == ContentValue.Json.Successcode) {
                    try {
                        JSONArray json = jsonObject.optJSONArray(ContentValue.Json.Content);
                        if (json != null) {
                            List<GeDanInfo> tempList = JSON.parseArray(json.toString(), GeDanInfo.class);
                            list.addAll(tempList);
                            adapter.setData(list);
                            onMSVSuccess(null);
                        } else {
                            if (isMsv) {
                                onFailure("未查询到相关歌单！");
                                isMore = false;
                            } else {
                                CommonUtil.showToast(GeDanListActivity.this, "未查询到相关歌单！");
                            }
                        }
                    } catch (Exception e) {
                        AppLog.Loge("Error:" + e.getMessage());
                        if (isMsv) {
                            onFailure("服务器繁忙，请稍后再试！");
                        } else {
                            CommonUtil.showToast(GeDanListActivity.this, "服务器繁忙，请稍后再试！");
                        }
                    }
                } else {
                    if (isMsv) {
                        onFailure("未查询到相关歌单！");
                    } else {
                        CommonUtil.showToast(GeDanListActivity.this, "未查询到相关歌单！");
                    }
                }
                binding.xrefreshview.stopLoadMore();
            }

            @Override
            public void onFailure(String msg) {
                if (isMsv) {
                    onMSVFailure(msg);
                } else {
                    CommonUtil.showToast(GeDanListActivity.this, msg);
                }
                binding.xrefreshview.stopLoadMore();
            }
        });
    }
}
