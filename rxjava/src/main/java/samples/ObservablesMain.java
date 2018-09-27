package samples;

import io.reactivex.Observable;

public class ObservablesMain {
    public static void main(String[] args) {
        Observable<Integer> obs1 = Observable.range(1, 10);
        Observable<Integer> map = obs1.map(i -> i + 1);
    }
}
