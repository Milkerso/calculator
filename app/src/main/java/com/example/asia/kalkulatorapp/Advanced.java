package com.example.asia.kalkulatorapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;

public class Advanced extends AppCompatActivity {

    private String numberOne = new String();
    private String numberTwo = new String();
    private TextView ekran;
    private String operacja = new String();
    private boolean powtDzialania = false;
    private boolean afterResult = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
    }


    public void click(View view) {
        ekran = (TextView) findViewById(R.id.textView);
        switch (view.getId()) {
            case R.id.zeroButton: {
                czyPoOperacji();
                if(numberOne.length() == 0)
                {
                    numberOne = numberOne + "0.";
                }
                else
                {
                    numberOne = numberOne + "0";
                }
                wyswietl();
                break;
            }
            case R.id.jedenButton: {
                czyPoOperacji();
                numberOne = numberOne + "1";
                wyswietl();
                break;
            }
            case R.id.dwaButton: {
                czyPoOperacji();
                numberOne = numberOne + "2";
                wyswietl();
                break;
            }
            case R.id.trzyButton: {
                czyPoOperacji();
                numberOne = numberOne + "3";
                wyswietl();
                break;
            }
            case R.id.czteryButton: {
                czyPoOperacji();
                numberOne = numberOne + "4";
                wyswietl();
                break;
            }
            case R.id.piecButton: {
                czyPoOperacji();
                numberOne = numberOne + "5";
                wyswietl();
                break;
            }
            case R.id.szescButton: {
                czyPoOperacji();
                numberOne = numberOne + "6";
                wyswietl();
                break;
            }
            case R.id.siedemButton: {
                czyPoOperacji();
                numberOne = numberOne + "7";
                wyswietl();
                break;
            }
            case R.id.osiemButton: {
                czyPoOperacji();
                numberOne = numberOne + "8";
                wyswietl();
                break;
            }
            case R.id.dziewiecButton: {
                czyPoOperacji();
                numberOne = numberOne + "9";
                wyswietl();
                break;
            }
            case R.id.plusButton: {
                sprawdz();
                operacja = "+";
                break;
            }
            case R.id.rownaButton: {
                oblicz();
                break;
            }
            case R.id.minusButton: {
                sprawdz();
                operacja = "-";
                break;
            }
            case R.id.razyButton: {
                sprawdz();
                operacja = "*";
                break;
            }
            case R.id.dzielenieButton: {
                sprawdz();
                operacja = "/";
                break;
            }
            case R.id.BkspButton: {
                if(numberOne.length() != 0){
                    numberOne = numberOne.substring(0, numberOne.length()-1);
                    wyswietl();
                }
                else
                {
                    Toast.makeText(this.getBaseContext(), "Nie można nic usunąć ",
                            Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.CButton: {
                czysc();
                break;
            }
            case R.id.znakButton: {
                if(afterResult == true)
                {
                    if(numberTwo.length() == 0)
                    {
                        Toast.makeText(this.getBaseContext(), "Nie wpisałeś liczby ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(numberTwo.charAt(0) != '-')
                    {
                        numberTwo = "-" + numberTwo;
                        ekran.setText(numberTwo);
                    }
                    else
                    {
                        numberTwo = numberTwo.substring(1,numberTwo.length());
                        ekran.setText(numberTwo);
                    }
                }
                else
                {
                    if(numberOne.length() == 0)
                    {
                        Toast.makeText(this.getBaseContext(), "Nie wpisałeś liczby ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(numberOne.charAt(0) != '-')
                    {
                        numberOne = "-" + numberOne;
                        ekran.setText(numberOne);
                    }
                    else
                    {
                        numberOne = numberOne.substring(1,numberOne.length());
                        ekran.setText(numberOne);
                    }
                }
                break;
            }
            case R.id.kropkaButton: {

                if(numberOne.length() == 0)
                {
                    numberOne = numberOne + "0.";
                }
                else
                {
                    if(czyJestKropka())
                    {
                        Toast.makeText(this.getBaseContext(), "Wpisałeś już kropkę ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        numberOne = numberOne + ".";
                    }
                }
                wyswietl();
                break;
            }
            case R.id.procButton: {
                if(numberOne.length() == 0 && numberTwo.length() == 0)
                {
                    Toast.makeText(this.getBaseContext(), "Najpierw podaj liczbe, a pózniej nacisnij procent ",
                            Toast.LENGTH_SHORT).show();
                }
                else if(afterResult)
                {
                    BigDecimal temp = new BigDecimal(Double.parseDouble(numberTwo)*100);
                    temp = temp.round(new MathContext(6));
                    ekran.setText(temp.toString()+"%");
                }
                else
                {
                    BigDecimal temp = new BigDecimal(Double.parseDouble(numberOne)*100);
                    temp = temp.round(new MathContext(6));
                    ekran.setText(temp.toString()+"%");
                }
                break;
            }
            case R.id.sinButton: {
                if(numberOne.length() == 0 && numberTwo.length() == 0)
                {
                    Toast.makeText(this.getBaseContext(), "Najpierw podaj liczbe, a pózniej nacisnij sinus ",
                            Toast.LENGTH_SHORT).show();
                }
                else if(afterResult || powtDzialania == true)
                {
                    BigDecimal temp = new BigDecimal(Math.sin(Double.parseDouble(numberTwo)));
                    temp = temp.round(new MathContext(6));
                    numberTwo = temp.toString();
                    ekran.setText(numberTwo);
                    numberOne = new String();
                }
                else
                {
                    BigDecimal temp = new BigDecimal(Math.sin(Double.parseDouble(numberOne)));
                    temp = temp.round(new MathContext(6));
                    numberOne = temp.toString();
                    ekran.setText(numberOne);
                }
                break;
            }
            case R.id.cosButton: {
                if(numberOne.length() == 0 && numberTwo.length() == 0)
                {
                    Toast.makeText(this.getBaseContext(), "Najpierw podaj liczbe, a pózniej nacisnij cosinus ",
                            Toast.LENGTH_SHORT).show();
                }
                else if(afterResult || powtDzialania == true)
                {
                    BigDecimal temp = new BigDecimal(Math.cos(Double.parseDouble(numberTwo)));
                    temp = temp.round(new MathContext(6));
                    numberTwo = temp.toString();
                    ekran.setText(numberTwo);
                    numberOne = new String();
                }
                else
                {
                    BigDecimal temp = new BigDecimal(Math.cos(Double.parseDouble(numberOne)));
                    temp = temp.round(new MathContext(6));
                    numberOne = temp.toString();
                    ekran.setText(numberOne);
                }
                break;
            }
            case R.id.tanButton: {
                if(numberOne.length() == 0 && numberTwo.length() == 0)
                {
                    Toast.makeText(this.getBaseContext(), "Najpierw podaj liczbe, a pózniej nacisnij tan ",
                            Toast.LENGTH_SHORT).show();
                }
                else if(afterResult || powtDzialania == true)
                {
                    BigDecimal temp = new BigDecimal(Math.tan(Double.parseDouble(numberTwo)));
                    temp = temp.round(new MathContext(6));
                    numberTwo = temp.toString();
                    ekran.setText(numberTwo);
                    numberOne = new String();
                }
                else
                {
                    BigDecimal temp = new BigDecimal(Math.tan(Double.parseDouble(numberOne)));
                    temp = temp.round(new MathContext(6));
                    numberOne = temp.toString();
                    ekran.setText(numberOne);
                }
                break;
            }
            case R.id.logButton: {
                if(numberOne.length() == 0 && numberTwo.length() == 0)
                {
                    Toast.makeText(this.getBaseContext(), "Najpierw podaj liczbe, a pózniej nacisnij log ",
                            Toast.LENGTH_SHORT).show();
                }
                else if(afterResult || powtDzialania == true)
                {
                    if(Double.parseDouble(numberTwo) <= 0)
                    {
                        Toast.makeText(this.getBaseContext(), "Nie można obliczyć z liczby mniejszej bądź równej zero ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        BigDecimal temp = new BigDecimal(Math.log10(Double.parseDouble(numberTwo)));
                        temp = temp.round(new MathContext(6));
                        numberTwo = temp.toString();
                        ekran.setText(numberTwo);
                        numberOne = new String();
                    }
                }
                else {
                    if (Double.parseDouble(numberOne) <= 0) {
                        Toast.makeText(this.getBaseContext(), "Nie można obliczyć z liczby mniejszej bądź równej zero ",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        BigDecimal temp = new BigDecimal(Math.log10(Double.parseDouble(numberOne)));
                        temp = temp.round(new MathContext(6));
                        numberOne = temp.toString();
                        ekran.setText(numberOne);
                    }
                }
                break;
            }
            case R.id.lnButton: {
                if(numberOne.length() == 0 && numberTwo.length() == 0)
                {
                    Toast.makeText(this.getBaseContext(), "Najpierw podaj liczbe, a pózniej nacisnij ln ",
                            Toast.LENGTH_SHORT).show();
                }
                else if(afterResult || powtDzialania == true)
                {
                    if(Double.parseDouble(numberTwo) <= 0)
                    {
                        Toast.makeText(this.getBaseContext(), "Nie można obliczyć z liczby mniejszej bądź równej zero ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        BigDecimal temp = new BigDecimal(Math.log(Double.parseDouble(numberTwo)));
                        temp = temp.round(new MathContext(6));
                        numberTwo = temp.toString();
                        ekran.setText(numberTwo);
                        numberOne = new String();
                    }
                }
                else {
                    if (Double.parseDouble(numberOne) <= 0) {
                        Toast.makeText(this.getBaseContext(), "Nie można obliczyć z liczby mniejszej bądź równej zero ",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        BigDecimal temp = new BigDecimal(Math.log(Double.parseDouble(numberOne)));
                        temp = temp.round(new MathContext(6));
                        numberOne = temp.toString();
                        ekran.setText(numberOne);
                    }
                }
                break;
            }
            case R.id.sqrtButton: {
                if(numberOne.length() == 0 && numberTwo.length() == 0)
                {
                    Toast.makeText(this.getBaseContext(), "Najpierw podaj liczbe, a pózniej nacisnij sqrt ",
                            Toast.LENGTH_SHORT).show();
                }
                else if(afterResult || powtDzialania == true)
                {
                    if(Double.parseDouble(numberTwo) <= 0)
                    {
                        Toast.makeText(this.getBaseContext(), "Nie można obliczyć z liczby mniejszej bądź równej zero ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        BigDecimal temp = new BigDecimal(Math.sqrt(Double.parseDouble(numberTwo)));
                        temp = temp.round(new MathContext(6));
                        numberTwo = temp.toString();
                        ekran.setText(numberTwo);
                        numberOne = new String();
                    }
                }
                else {
                    if (Double.parseDouble(numberOne) <= 0) {
                        Toast.makeText(this.getBaseContext(), "Nie można obliczyć z liczby mniejszej bądź równej zero ",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        BigDecimal temp = new BigDecimal(Math.sqrt(Double.parseDouble(numberOne)));
                        temp = temp.round(new MathContext(6));
                        numberOne = temp.toString();
                        ekran.setText(numberOne);
                    }
                }
                break;
            }
            case R.id.x2Button: {
                if(numberOne.length() == 0 && numberTwo.length() == 0)
                {
                    Toast.makeText(this.getBaseContext(), "Najpierw podaj liczbe, a pózniej nacisnij X^2 ",
                            Toast.LENGTH_SHORT).show();
                }
                else if(afterResult || powtDzialania == true)
                {

                        BigDecimal temp = new BigDecimal(Math.pow(Double.parseDouble(numberTwo),2));
                        temp = temp.round(new MathContext(6));
                        numberTwo = temp.toString();
                        wyswietl2(temp);
                        numberOne = new String();

                }
                else {

                        BigDecimal temp = new BigDecimal(Math.pow(Double.parseDouble(numberOne),2));
                        temp = temp.round(new MathContext(6));
                        numberOne = temp.toString();
                        wyswietl3(temp);
                }
                break;
            }
            case R.id.xyButton: {
                sprawdz();
                operacja = "^";
                break;
            }




        }

    }
    public boolean czyJestKropka(){
        boolean czyJestKropkaa = false;

        for(int i = 0; i < numberOne.length(); i++)
        {
            if(numberOne.charAt(i) == '.')
            {
                czyJestKropkaa = true;
            }
        }
        return czyJestKropkaa;
    }
    public boolean czyJestKropka2(){
        boolean czyJestKropkaa = false;

        for(int i = 0; i < numberTwo.length(); i++)
        {
            if(numberTwo.charAt(i) == '.')
            {
                czyJestKropkaa = true;
            }
            if(numberTwo.charAt(i) == 'E')
            {
                czyJestKropkaa = false;
            }
        }
        return czyJestKropkaa;
    }
    public void czysc(){
        ekran.setText("");
        numberOne = new String();
        numberTwo = new String();
        powtDzialania = false;
    }
    public void czyPoOperacji(){
        if(afterResult == true)
        {
            afterResult = false;
            numberOne = new String();

        }
    }
    public void sprawdz(){
        if(afterResult == true)
        {

        }
        else if(powtDzialania == true)
        {
            oblicz();
            numberOne = new String();
        }
        else if(powtDzialania == false)
        {
            numberTwo = numberOne;
            numberOne = new String();
            powtDzialania = true;
        }

    }
    public void wyswietl(){
        ekran.setText(numberOne);

    }
    public void wyswietl2(BigDecimal valueTwo)
    {
        if(valueTwo.doubleValue() > 10000000000.0){
            Toast.makeText(this.getBaseContext(), "Przekroczyleś zakres ",
                    Toast.LENGTH_SHORT).show();
            czysc();
        }
        else {
            valueTwo = valueTwo.round(new MathContext(6));
            numberTwo = valueTwo.toString();
            ucinanieZer();
            ekran.setText(numberTwo);
        }
    }
    public void wyswietl3(BigDecimal valueOne)
    {
        if(valueOne.doubleValue() > 10000000000.0){
            Toast.makeText(this.getBaseContext(), "Przekroczyleś zakres ",
                    Toast.LENGTH_SHORT).show();
            czysc();
        }
        else {
            valueOne = valueOne.round(new MathContext(6));
            numberOne = valueOne.toString();
            ucinanieZer();
            ekran.setText(numberOne);
        }
    }
    public void ucinanieZer() {
        if (czyJestKropka2())
        {
            boolean nieZero = false;
            int ileUsunac = 0;
            for(int i = numberTwo.length()-1 ; i > 0; i--)
            {
                if(numberTwo.charAt(i) != '0')
                {
                    nieZero = true;
                }
                if(numberTwo.charAt(i) == '0' && nieZero==false)
                {
                    ileUsunac++;
                }
            }
            numberTwo = numberTwo.substring(0,numberTwo.length()-ileUsunac);
            if(numberTwo.charAt(numberTwo.length()-1)=='.')
            {
                numberTwo=numberTwo.substring(0,numberTwo.length()-1);
            }
        }

    }

    public void oblicz(){
        afterResult = true;
        if(numberOne.length() != 0 && numberTwo.length() != 0)
        {
            BigDecimal valueOne =new BigDecimal(Double.parseDouble(numberOne));
            BigDecimal valueTwo = new BigDecimal(Double.parseDouble(numberTwo));
            if(operacja == "+")
            {
                valueTwo = valueTwo.add(valueOne);
                wyswietl2(valueTwo);
            }
            else if(operacja == "-")
            {
                valueTwo = valueTwo.subtract(valueOne);
                wyswietl2(valueTwo);
            }
            else if(operacja == "*")
            {
                valueTwo = valueTwo.multiply(valueOne);
                wyswietl2(valueTwo);
            }
            else if(operacja == "/")
            {
                if(valueOne.equals(new BigDecimal(0))) {
                    Toast.makeText(this.getBaseContext(), "Nie dziel przez 0",
                            Toast.LENGTH_SHORT).show();
                    czysc();
                }
                else
                {
                    valueTwo = valueTwo.divide(valueOne, 6, BigDecimal.ROUND_HALF_DOWN);
                    wyswietl2(valueTwo);
                }
            }

            else if(operacja == "^")
            {
                if(valueOne.doubleValue() > 50.0 || valueTwo.doubleValue() > 100) {
                    Toast.makeText(this.getBaseContext(), "Przekroczyłes zakres",
                            Toast.LENGTH_SHORT).show();
                    czysc();
                }
                else {
                    valueTwo = new BigDecimal(Math.pow(Double.parseDouble(numberTwo), Double.parseDouble(numberOne)));
                    wyswietl2(valueTwo);
                }
            }

        }


    }
}
