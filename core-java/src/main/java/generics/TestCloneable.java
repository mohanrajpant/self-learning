package generics;

public class TestCloneable {


    public static void main(String[] args) {
        ConfusedPerson1 confusedPerson1 = new ConfusedPerson1("me");
        confusedPerson1.clone();

        doubleClone(confusedPerson1);

        ConfusedPerson2 confusedPerson2 = new ConfusedPerson2("you");
        doubleClone(confusedPerson2);

    }

    private static  <T extends Cloneable> void doubleClone(Cloneable<?> confusedPerson) {
        confusedPerson.clone().clone();
    }
}