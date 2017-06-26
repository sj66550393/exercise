package anne.com.sj.mvpexercise.view;

/**
 * Created by Administrator on 2017/6/26.
 */
public interface IWeatherView {

    public void updateWeatherInfo(String str);
    public void showWaitingDialog();
    public void dismissWaitingDialog();
}
