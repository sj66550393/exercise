package anne.com.sj.mvpexercise.model;

/**
 * Created by Administrator on 2017/6/26.
 */
public class IWeatherImpl implements IWeatherModel {

    private String mWeather;
    @Override
    public String getString() {
        return mWeather;
    }

    @Override
    public void setString(String str) {
        mWeather = str;
    }
}
