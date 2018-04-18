// Assignment 1 Solution: Account.cpp
// Account class implementation
//
// Alex (Xiaochen) Dai
// May 8, 2016

#include <iostream>
#include "Account.h"

using namespace std;

// Constructor
Account::Account(int balance)
{
    if (balance >= 0) {
        this->balance = balance;
    } else {
        this->balance = 0;
        cout << "Error: Initial balance cannot be negative.\n" << endl;
    }
}

// Deposit money into the account
void Account::credit(int amountToAdd)
{
    if (amountToAdd >= 0) {
        balance += amountToAdd;
    } else {
        cout << "Error: Credit amount cannot be negative.\n" << endl;
    }
}

// Withdraw money from the account
void Account::debit(int amountToWithdraw)
{
    if (amountToWithdraw < 0) {
        cout << "Error: Debit amount cannot be negative\n" << endl;
    } else if(amountToWithdraw <= balance) {
        balance -= amountToWithdraw;
    } else {
        cout << "Debit amount exceeded account balance.\n" << endl;
    }
}

// get the current amount of balance
int Account::getBalance()
{
    return balance;
}