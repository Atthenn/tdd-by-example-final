package guru.springframework;

public interface Expression {
    //Expression plus(Money addend);

    Money reduce(Bank bank, String to);
    public Expression plus(Expression addend);

    Expression times(int i);
}
