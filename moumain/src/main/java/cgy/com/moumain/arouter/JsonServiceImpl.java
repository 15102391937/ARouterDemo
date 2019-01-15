package cgy.com.moumain.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

@Route(path = "/main/json")
public class JsonServiceImpl implements SerializationService {

    private Gson mGson;

    @Override
    public void init(Context context) {
        Log.e("ARouter", "位于 main 中的json初始化了");
        mGson = new Gson();
    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        checkJson();
        return mGson.fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        checkJson();
        return mGson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        checkJson();
        return mGson.fromJson(input, clazz);
    }

    private void checkJson() {
        if (mGson == null) {
            mGson = new Gson();
        }
    }
}

