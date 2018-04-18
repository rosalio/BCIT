// Assignment 1 Solution: Account.h
// Account class interface
//
// Alex (Xiaochen) Dai
// May 8, 2016

class Account
{
public:
    explicit Account(int balance);  // Constructor to create an account
    void credit(int amountToAdd);   // Deposit money into the account
    void debit(int amountToWithdraw);   // Withdraw money from the account
    int getBalance();   // Get the current balance

private:
    int balance;    // Data member: the balance of account
};