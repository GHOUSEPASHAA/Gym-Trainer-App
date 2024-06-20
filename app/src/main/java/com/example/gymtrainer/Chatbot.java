package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Chatbot extends AppCompatActivity {

    private EditText editTextMessage;
    private LinearLayout linearLayoutChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        editTextMessage = findViewById(R.id.editTextMessage);
        linearLayoutChat = findViewById(R.id.linearLayoutChat);
        addMessageToChat("Bot", "Welcome!My name is Selena. Feel free to ask me about leg exercises, chest exercises,shoulder exercises,bicep exercises" +
                "how are you,tell about yourself, or request a diet plan  male or females.");
        addMessageToChat("Bot", "You can also ask me to calculate your weight based on your height.like calculate weight for my height 1.7");
        Button buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = editTextMessage.getText().toString().trim();
        if (!message.isEmpty()) {
            // if (questionsAnswered < 5) {
            addMessageToChat("User", message);
            String botResponse = getBotResponse(message);
            addMessageToChat("Bot", botResponse);
            editTextMessage.setText("");
            // questionsAnswered++;
            //   } else {
            // addMessageToChat("Bot", "Sorry, I can only answer 5 questions.");
            //  }
        }
    }

    private String getBotResponse(String message) {
        // Normalize the message to lowercase for easier comparison
        String lowerCaseMessage = message.toLowerCase();

        // Check the message for specific keywords and generate responses accordingly
        if (lowerCaseMessage.contains("leg exercises")) {
            return "Some leg exercises you can try are squats, lunges, and calf raises.";
        } else if (lowerCaseMessage.contains("chest exercises")) {
            return "For chest exercises, you can do bench press, push-ups, and chest flyes.";
        } else if (lowerCaseMessage.contains("diet plan male")) {
            return "A diet plan for males typically includes lean proteins, complex carbohydrates, and healthy fats. It's important to eat a balanced diet and watch portion sizes.";
        } else if (lowerCaseMessage.contains("diet plan female")) {
            return "For females, a diet plan may focus on similar principles of balanced nutrition with a focus on meeting specific nutrient needs. It's important to consult with a nutritionist or dietitian for personalized recommendations.";
        }else if (lowerCaseMessage.contains("bicep exercises")) {
            return "Bicep exercises include bicep curls, hammer curls, and chin-ups.";
        } else if (lowerCaseMessage.contains("tricep exercises")) {
            return "Tricep exercises include tricep dips, overhead tricep extensions, and tricep kickbacks.";
        } else if (lowerCaseMessage.contains("abs exercises")) {
            return "Abs exercises include crunches, planks, and leg raises.";
        } else if (lowerCaseMessage.contains("shoulder exercises")) {
            return "Shoulder exercises include shoulder press, lateral raises, and front raises.";
        }else if (lowerCaseMessage.contains("how are you")) {
            return " Iam Absolutely fine! How About You";
        }else if (lowerCaseMessage.contains("tell about yourself")) {
            return " Iam a chatbot named Selena. My age is 1 week.Iam created by Mr Jack Sparrow AKA Ghouse pasha.I like Android 11";
        }else if (lowerCaseMessage.contains("i like you")) {
            return " Iam glad to hear it from you !I like you too";
        }

        else if (lowerCaseMessage.contains("calculate weight")) {
            // Extract height from the message
            double heightInMeters = extractHeight(message); // Assuming height is provided in meters

            // Calculate weight using BMI formula: weight = BMI * height^2
            // For simplicity, let's assume the BMI value based on average BMI ranges
            double bmi = 22.0; // Average BMI value
            double weight = bmi * Math.pow(heightInMeters, 2);

            return "Based on your height of " + heightInMeters + " meters, your weight could be approximately " + weight + " kilograms.";
        }






        else {
            return "I'm sorry, I don't understand. Please ask about leg exercises, chest exercises, or specify your gender for a diet plan.";
        }

    }
    private double extractHeight(String message) {
        double height = 0.0;

        // Split the message into words
        String[] words = message.toLowerCase().split("\\s+");

        // Iterate through the words to find the height value
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("height") || words[i].equals("tall")) { // Check for "height" or "tall"
                // Try to parse the next word as a double value representing the height
                if (i + 1 < words.length) {
                    try {
                        // Check if the next word contains a number (representing height)
                        String nextWord = words[i + 1];
                        if (nextWord.matches("\\d+(\\.\\d+)?")) {
                            height = Double.parseDouble(nextWord);
                            break; // Exit loop once height is found
                        }
                    } catch (NumberFormatException e) {
                        // If parsing fails, continue to the next word
                        continue;
                    }
                }
            }
        }

        return height;
    }



    private void addMessageToChat(String sender, String message) {
        TextView textView = new TextView(this);
        textView.setText(sender + ": " + message);

        linearLayoutChat.addView(textView);

        ScrollView scrollViewChat = findViewById(R.id.scrollViewChat);
        scrollViewChat.post(new Runnable() {
            @Override
            public void run() {
                scrollViewChat.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
}