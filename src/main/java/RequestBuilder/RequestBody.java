package RequestBuilder;

import java.lang.reflect.InvocationTargetException;

public class RequestBody<T> {
private T object;
    public RequestBody(Class<T>requestClass) {
        try {
           object= requestClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


public RequestBody buildRequestBodyObject(String fieldName, Object value){
    try {
        Class<T>tClass= (Class<T>) object.getClass();

        tClass.getField(fieldName).set(object,value);
        object.getClass().getField(fieldName).set(object,value);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    } catch (NoSuchFieldException e) {
        throw new RuntimeException(e);
    }
    return this;
}
public T returnRequestBodyObject(){
        return object;
}

}
