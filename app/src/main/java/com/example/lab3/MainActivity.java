package com.example.lab3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> secretWords;
    private String chosenWord;

    private TextView scrambledWordTextView;

    char nextLetter;
    int incorrectCounter;
    int correctCounter;

    private Random random;
    String correctGuess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        scrambledWordTextView = (TextView) findViewById(R.id.scrambledWordTextView);
        TextView instructions = (TextView) findViewById(R.id.introTextView);
        instructions.setText("Try to guess the secret word, one letter at a time.");


        ArrayList<String> secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY"));





        //chooseWord();
        correctCounter = 0;
        random = new Random();
        int index = random.nextInt(secretWords.size());
        chosenWord = secretWords.get(index);

        chosenWord = secretWords.get(random.nextInt(secretWords.size()));

        String shuffledWord = "";
        ArrayList<String> splitWord = new ArrayList(Arrays.asList(chosenWord.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord)
            shuffledWord += c;


        TextView t = (TextView) findViewById(R.id.scrambledWordTextView);
        t.setText(shuffledWord);

        nextLetter = chosenWord.charAt(correctCounter);

        incorrectCounter = 0;

        correctGuess = "";

    }


  /*  public void chooseWord() {

        chosenWord = secretWords.get(random.nextInt(secretWords.size()));

        String shuffledWord = "";
        ArrayList<String> splitWord = new ArrayList(Arrays.asList(chosenWord.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord)
            shuffledWord += c;


        scrambledWordTextView.setText(shuffledWord.toUpperCase());
    } */



    public void guessButtonClicked(View v) {


    TextView userInput = (TextView) findViewById(R.id.userInput);
    TextView correctGuessView = (TextView) findViewById(R.id.correctGuessTextView);
    TextView winText = (TextView) findViewById(R.id.introTextView);
    TextView incorrectText = (TextView) findViewById(R.id.incorrectCounterView);



    String s = userInput.getText().toString();
    s = s.toUpperCase();
    char c = s.charAt(0);


    if (nextLetter == c) {
        correctGuess += c;
        correctCounter++;

        if (!chosenWord.equals(correctGuess)) {
            nextLetter = chosenWord.charAt(correctCounter);
        }

        correctGuessView.setText(correctGuess);

        }

        else {
        incorrectCounter++;
        incorrectText.setText("Incorrect guesses: " + incorrectCounter);

    }
    //clears
    userInput.setText("");

        if (chosenWord.equals(correctGuess)) {
            winText.setText("You win! You guessed the word with " + Integer.toString(incorrectCounter) + " incorrect guesses.");
        }
    }











    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
