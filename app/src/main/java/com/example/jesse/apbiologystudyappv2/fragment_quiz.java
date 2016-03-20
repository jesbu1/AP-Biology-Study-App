package com.example.jesse.apbiologystudyappv2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class fragment_quiz extends Fragment {
    static ArrayList<String> array_of_questions = new ArrayList<>();
    static ArrayList<String> array_of_answers = new ArrayList<>();
    static int firstrightquestion;
    static int secondrightquestion;
    static int thirdrightquestion;
    static int fourthrightquestion;
    static int fifthrightquestion;
    int question_number = 1;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    TextView question_textView;
    Button submit_button;
    TextView correct_incorrect;
    int submit = 0;
    RadioGroup radioGroup;
    TextView question_number_textview;


    public fragment_quiz() {
        // Required empty public constructor
    }

    public static fragment_quiz newInstance(ArrayList<String> arrayofquestions, ArrayList<String> arrayofanswers,
                                            int first_right_question, int second_right_question, int third_right_question,
                                            int fourth_right_question, int fifth_right_question) {
        array_of_questions = arrayofquestions;
        array_of_answers = arrayofanswers;
        firstrightquestion = first_right_question;
        secondrightquestion = second_right_question;
        thirdrightquestion = third_right_question;
        fourthrightquestion = fourth_right_question;
        fifthrightquestion = fifth_right_question;
        return new fragment_quiz();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioButton1 = (RadioButton) view.findViewById(R.id.answer_1);
        radioButton2 = (RadioButton) view.findViewById(R.id.answer_2);
        radioButton3 = (RadioButton) view.findViewById(R.id.answer_3);
        radioButton4 = (RadioButton) view.findViewById(R.id.answer_4);
        submit_button = (Button) view.findViewById(R.id.submit_button);
        question_textView = (TextView) view.findViewById(R.id.question);
        correct_incorrect = (TextView) view.findViewById(R.id.correct_or_incorrect_textview);
        question_number_textview = (TextView) view.findViewById(R.id.question_number);
        question_textView.setText(array_of_questions.get(0));
        radioButton1.setText(array_of_answers.get(0));
        radioButton2.setText(array_of_answers.get(1));
        radioButton3.setText(array_of_answers.get(2));
        radioButton4.setText(array_of_answers.get(3));
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressSubmit();
            }
        });
        correct_incorrect.setVisibility(correct_incorrect.INVISIBLE);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);

    }

    public void correctAnswerSetText() {
        correct_incorrect.setText("Correct!");
        correct_incorrect.setVisibility(correct_incorrect.VISIBLE);
    }

    public void setRadioButtons(int i) {
        radioButton1.setText(array_of_answers.get(i));
        radioButton2.setText(array_of_answers.get(i + 1));
        radioButton3.setText(array_of_answers.get(i + 2));
        radioButton4.setText(array_of_answers.get(i + 3));

    }

    public RadioButton findCorrectRadioButton(int rightanswer) {
        int radiobutton1 = 1;
        int radiobutton2 = 2;
        int radiobutton3 = 3;
        if (radiobutton1 == rightanswer) {
            return radioButton1;
        } else if (radiobutton2 == rightanswer) {
            return radioButton2;
        } else if (radiobutton3 == rightanswer) {
            return radioButton3;
        } else {
            return radioButton4;
        }
    }


    public void setRepetitiveEndStuff(int i) {
        setRadioButtons(i);
        correct_incorrect.setVisibility(correct_incorrect.INVISIBLE);
        question_number_textview.setText("Question " + question_number + " of 5");
        radioGroup.clearCheck();
        question_textView.setText(array_of_questions.get(question_number - 1));
    }

    public void setSubmitButtonToNextQuestion() {
        submit_button.setText("Next Question");
        submit = 1;
    }

    public void setRepetitiveBeginningStuff() {
        submit_button.setText("Submit");
        submit = 0;
        question_number++;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_quiz, container, false);
    }

    public void pressSubmit() {
        //when user presses submit button for quiz
        if (question_number < 6) {
            if (radioGroup.getCheckedRadioButtonId() != -1) {
                if (submit == 0) {
                    if (question_number == 1) {
                        if (findCorrectRadioButton(firstrightquestion).isChecked() == true) {
                            correctAnswerSetText();
                        } else {
                            correct_incorrect.setText("Incorrect, the correct answer is " + array_of_answers.get(firstrightquestion - 1));
                            correct_incorrect.setVisibility(correct_incorrect.VISIBLE);
                        }
                        setSubmitButtonToNextQuestion();

                    } else if (question_number == 2) {
                        if (findCorrectRadioButton(secondrightquestion).isChecked() == true) {
                            correctAnswerSetText();
                        } else {
                            correct_incorrect.setText("Incorrect, the correct answer is " + array_of_answers.get(secondrightquestion + 3));
                            correct_incorrect.setVisibility(correct_incorrect.VISIBLE);
                        }
                        setSubmitButtonToNextQuestion();

                    } else if (question_number == 3) {
                        if (findCorrectRadioButton(thirdrightquestion).isChecked() == true) {
                            correctAnswerSetText();
                        } else {
                            correct_incorrect.setText("Incorrect, the correct answer is " + array_of_answers.get(thirdrightquestion + 7));
                            correct_incorrect.setVisibility(correct_incorrect.VISIBLE);
                        }
                        setSubmitButtonToNextQuestion();
                    } else if (question_number == 4) {
                        if (findCorrectRadioButton(fourthrightquestion).isChecked() == true) {
                            correctAnswerSetText();
                        } else {
                            correct_incorrect.setText("Incorrect, the correct answer is " + array_of_answers.get(fourthrightquestion + 11));
                            correct_incorrect.setVisibility(correct_incorrect.VISIBLE);
                        }
                        setSubmitButtonToNextQuestion();
                    } else if (question_number == 5) {
                        if (findCorrectRadioButton(fifthrightquestion).isChecked() == true) {
                            correctAnswerSetText();
                        } else {
                            correct_incorrect.setText("Incorrect, the correct answer is " + array_of_answers.get(fifthrightquestion + 15));
                            correct_incorrect.setVisibility(correct_incorrect.VISIBLE);
                        }
                        setSubmitButtonToNextQuestion();
                    }
                }

                //change to submit again and redo the answer/question
                else {
                    if (question_number == 1) {
                        setRepetitiveBeginningStuff();
                        setRepetitiveEndStuff(4);
                    } else if (question_number == 2) {
                        setRepetitiveBeginningStuff();
                        setRepetitiveEndStuff(8);
                    } else if (question_number == 3) {
                        setRepetitiveBeginningStuff();
                        setRepetitiveEndStuff(12);
                    } else if (question_number == 4) {
                        setRepetitiveBeginningStuff();
                        setRepetitiveEndStuff(16);
                    } else if (question_number == 5) {
                        radioGroup.clearCheck();
                        question_textView.setText("No more questions! Move On :)");
                        submit_button.setText("No More!");
                        question_number++;
                        correct_incorrect.setVisibility(correct_incorrect.INVISIBLE);

                    }
                }

            }
        }
    }
}