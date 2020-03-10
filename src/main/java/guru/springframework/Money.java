package guru.springframework;

import java.util.Objects;

    public  class Money implements Expression {

        protected final int amount;
        protected final String currency;

        public Money(int amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

      //  public abstract String currency();
     //   @Override
        public String currency() {
            return currency;
        }

     //   public Expression plus(Money addend){
       //    return new Sum(this, addend);
         //   return new Money(amount + addend.amount, currency);
        //}

        @Override
        public Money reduce(Bank bank,String to){
            //return this;
            return  new Money(amount / bank.rate(this.currency,to),to);
        }

        @Override
        public Expression plus(Expression addend) {
            return new Sum(this, addend);
        }

        public static Money dollar(int amount){

           return new Money(amount, "USD");
        }

        public static Money franc(int amount){

            return new Money(amount,"CHF");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null ) return false;
            Money money = (Money) o;
            return amount == money.amount && this.currency.equals(money.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount);
        }

        @Override
        public String toString() {
            return "Money{" +
                    "amount=" + amount +
                    ", currency='" + currency + '\'' +
                    '}';
        }

        @Override
        public Expression times(int i) {
            return  new Money(amount*i, this.currency);
        }
    }
