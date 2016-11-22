package detectors;

public interface Detector<T> {
    T judge(T t1, T t2);

}
