package anne.com.sj.mvpexercise.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import anne.com.sj.mvpexercise.R;
import anne.com.sj.mvpexercise.presenter.WeatherPresenter;

public class MainActivity extends AppCompatActivity implements IWeatherView{

    private static final String TAG = "MVPexercise";

    private WeatherPresenter mWeatherPresenter;
    private Button btn_weather;
    private ProgressDialog mDialog;
    private TextView tv_weather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWeatherPresenter = new WeatherPresenter(this);
        tv_weather = (TextView) findViewById(R.id.tv_weather);
        btn_weather = (Button) findViewById(R.id.btn_weather);
        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG , "onclick");
                mWeatherPresenter.updateWeather();
            }
        });
    }

    @Override
    public void updateWeatherInfo(final String str) {
        Log.d(TAG , "updateWeatherInfo");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_weather.setText(str);
            }
        });
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mDialog != null && mDialog.isShowing())
                    mDialog.dismiss();
                Log.d(TAG , "showWaitingDialog");
                mDialog = ProgressDialog.show(MainActivity.this,"", "正在获取中...");
            }
        });

    }

    @Override
    public void dismissWaitingDialog() {
        Log.d(TAG , "dissmissWaitingDialog");
        if(mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
    }
}
