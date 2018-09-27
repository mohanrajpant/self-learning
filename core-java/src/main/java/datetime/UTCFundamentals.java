package datetime;

import java.time.Clock;

public class UTCFundamentals {

    public static void main(String[] args) {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());

    }
}
