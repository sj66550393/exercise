package anne.com.sj.mvpexercise.presenter;
import anne.com.sj.mvpexercise.model.IWeatherImpl;
import anne.com.sj.mvpexercise.model.IWeatherModel;
import anne.com.sj.mvpexercise.view.IWeatherView;

/**
 * Created by Administrator on 2017/6/26.
 */
public class WeatherPresenter {
    private IWeatherView mView;
    private IWeatherModel mModel;

    public WeatherPresenter(IWeatherView view){
        mView = view;
        mModel = new IWeatherImpl();
    }

    private void setInfo(String str){
        mModel.setString(str);
    }

    private String getInfo(){
        return mModel.getString();
    }

    private void updateWeatherInfo(String str){
        mView.updateWeatherInfo(str);
    }

    private void showWaitingDialog(){
        mView.showWaitingDialog();
    }

    private void dismissWaitingDialog(){
        mView.dismissWaitingDialog();
    }

    public void updateWeather(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    showWaitingDialog();
                    Thread.sleep(6000);
                    String weather = "21度,请转多云";
                    setInfo(weather);
                    String localWeather = getInfo();
                    updateWeatherInfo(localWeather);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    dismissWaitingDialog();
                }
            }
        }).start();
    }
}
