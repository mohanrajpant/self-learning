package stream;

import stream.domain.Trader;
import stream.domain.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;

public class TraderTransactionsMain {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        // 1.Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("1.Find all transactions in the year 2011 and sort them by value (small to high)");
        List<Transaction> transactions1 = transactions.stream()
            .filter(transaction -> transaction.getYear() == 2011)
            .sorted(comparing(Transaction::getValue))
            .collect(Collectors.toList());
        transactions1.forEach(System.out::println);
        System.out.println("");

        //2.  What are all the unique cities where the traders work?
        System.out.println("2.  What are all the unique cities where the traders work?");
        transactions.stream()
            .map(Transaction::getTrader)
            .map(Trader::getCity)
            .distinct()
            .forEach(System.out::println);
        System.out.println("");

        //3.  Find all traders from Cambridge and sort them by name.
        System.out.println("3.  Find all traders from Cambridge and sort them by name.");
        transactions.stream()
            .map(Transaction::getTrader)
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct()
            .sorted(comparing(Trader::getName))
            .forEach(System.out::println);
        System.out.println("");

        //4.  Return a string of all traders’ names sorted alphabetically.
        System.out.println("4.  Return a string of all traders’ names sorted alphabetically.");
        String allTraderNames = transactions.stream()
            .map(Transaction::getTrader)
            .map(Trader::getName)
            .distinct()
            .sorted()
            .collect(joining(", "));
        System.out.println(allTraderNames);
        System.out.println("");

        //5.  Are any traders based in Milan?
        System.out.println("5.  Are any traders based in Milan?");
        boolean milan_ = transactions.stream()
            .map(Transaction::getTrader)
            .anyMatch(trader -> trader.getCity().equals("Milan "));
        System.out.println(milan_);
        System.out.println("");

        //6.  Print all transactions’ values from the traders living in Cambridge.
        System.out.println("6.  Print all transactions’ values from the traders living in Cambridge.");
        transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .forEach(System.out::println);
        System.out.println("");

        //7.  What’s the highest value of all the transactions?
        System.out.println("7.  What’s the highest value of all the transactions?");
        Optional<Integer> max = transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .reduce(Integer::max);
        System.out.println(max.get());
        System.out.println("");

        //Find highest transaction based on transaction value
        Optional<Transaction> maxTransaction1 = transactions.stream()
            .max(Comparator.comparing(Transaction::getValue));
        Optional<Transaction> maxTransaction2 = transactions.stream()
            .collect(maxBy(Comparator.comparing(Transaction::getValue)));

        System.out.printf("maxTransaction1 {%s}\nmaxTransaction2 {%s} \n\n", maxTransaction1, maxTransaction2);

        //8.  Find the transaction with the smallest value.
        System.out.println("8.  Find the transaction with the smallest value.");
        Optional<Transaction> transaction = transactions.stream()
            .min(comparing(Transaction::getValue));
        System.out.println(transaction.get());
        System.out.println("");


        //Primitive Specialisations
        OptionalInt max1 = transactions.stream()
            .mapToInt(Transaction::getValue)
            .max();
        System.out.println(max1.getAsInt());
        System.out.println();

        Stream .iterate(0, n -> n + 2)
            .limit(10)
            .forEach(System.out::println);
        System.out.println();

        Stream.iterate(new int[]{0, 1}, t -> new int [] {t[1], t[1] + t[0]})
            .limit(10)
            .map(t -> t[0])
            .forEach(System.out::println);

    }
}
