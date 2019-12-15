package stream;

public class Transaction {
private Trader trader;
private int	year;
private int deal;
public Transaction(Trader trader, int year, int deal) {
	super();
	this.trader = trader;
	this.year = year;
	this.deal = deal;
}
@Override
public String toString() {
	return "Transaction [trader=" + trader + ", year=" + year + ", deal=" + deal + "]";
}
public Trader getTrader() {
	return trader;
}
public void setTrader(Trader trader) {
	this.trader = trader;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getDeal() {
	return deal;
}
public void setDeal(int deal) {
	this.deal = deal;
}
}
