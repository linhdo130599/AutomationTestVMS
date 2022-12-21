package com.example.tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        GmailLogin.class,
        LoginOTPGmailTest.class,
        Normal1NotagonlysaveTest.class})

public class AllTest {

}
