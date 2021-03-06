package news.brotherlu.com.newsapp.pager.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import news.brotherlu.com.newsapp.R;
import news.brotherlu.com.newsapp.activity.ContentActivity;

/**
 * Created by Administrator on 2017/9/21.
 * 基类pager用于给home、news等模块
 */

public class BasePager {
    //上下文
    public final Context context;
    //视图代表各个页面
    public View rootView;
    //textview文字
    public TextView title;
    //边上的ImageButton
    public ImageButton button;
    //content
    public FrameLayout content;

    public BasePager(Context context){
        this.context = context;
        rootView = initView();
    }

    /**
     * 初始化视图包括大部分公共视图
     * @return
     */
    protected View initView() {
        View view = View.inflate(context, R.layout.base_pager,null);
        title = view.findViewById(R.id.base_title_desc);
        button = view.findViewById(R.id.base_title_image);
        content = view.findViewById(R.id.base_content);

        //为button设置点击事件，点击打开右边菜单栏
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentActivity contentActivity = (ContentActivity) context;
                contentActivity.getSlidingMenu().toggle();//如果是开着就关闭，若是关着就打开
            }
        });
        return view;
    }

    /**
     * 子类实现该方法，用于初始化自身的数据
     */
    public void initData(){

    }
}
