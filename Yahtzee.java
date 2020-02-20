/*
*Simple yahtzee game
*/
/**
*author Jackmay
*/




package jack369;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.Random;

public class Yahtzee extends Application {
    private Canvas layout;
    private int die1 = 3;
    private int die2 = 5;
    private int die3 = 4;
    private int die4 = 6;
    private int die5 = 1;

    private int count;

    Random rand = new Random();

    private Button rollButton;
    private int frameNumber;

    private AnimationTimer timer = new AnimationTimer() {
        // The timer is used to animate "rolling" of the dice.
        // In each frame, the dice values are randomized.  When
        // the number of frames reaches 60, the timer stops itself.
        // The rollButton is disabled while an animation is in
        // progress, so it has to be enabled when the animation stops.
        public void handle( long time ) {
            
            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            die3 = rand.nextInt(6) + 1;
            die4 = rand.nextInt(6) + 1;
            die5 = rand.nextInt(6) + 1;
            draw();

            frameNumber++;
            if (frameNumber == 60) {
                timer.stop();
                rollButton.setDisable(false);
            }
        }
    };
    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Yahtzee");
        //Actual layout
        layout = new Canvas(400, 200);
        draw();

        final Label result = new Label("Hi! you have 3 trials only.");

        HBox pickOrder = new HBox();
        pickOrder.setPadding(new Insets(14));
        pickOrder.setSpacing(82);

        CheckBox dice1 = new CheckBox();
        CheckBox dice2 = new CheckBox();
        CheckBox dice3 = new CheckBox();
        CheckBox dice4 = new CheckBox();
        CheckBox dice5 = new CheckBox();
        pickOrder.getChildren().addAll(dice1,dice2,dice3,dice4,dice5);


        dice1.setDisable(true);
        dice2.setDisable(true);
        dice3.setDisable(true);
        dice4.setDisable(true);
        dice5.setDisable(true);

        rollButton = new Button("Roll Dice");

        rollButton.setOnAction(e -> {
            if (count == 0) {
                roll();
                result.setText("You have rolled " + count + " time(s).");

            }

            count++;
            dice1.setDisable(false);
            dice2.setDisable(false);
            dice3.setDisable(false);
            dice4.setDisable(false);
            dice5.setDisable(false);

            if (count !=0 && count < 4) {

                for (Node i : pickOrder.getChildren()){
                    CheckBox allboxes = (CheckBox) i;
                    if(!allboxes.isSelected()){
                        if(allboxes == dice1)
                            die1 =  rand.nextInt(6) + 1;
                        if (allboxes == dice2)
                            die2 =  rand.nextInt(6) + 1;
                        if(allboxes == dice3)
                            die3 =  rand.nextInt(6) + 1;
                        if(allboxes == dice4)
                            die4 =  rand.nextInt(6) + 1;
                        if(allboxes == dice5)
                            die5 =  rand.nextInt(6) + 1;
                        draw();
                    }
                }
                if (count<=3)
                    result.setText("You have rolled "+ count + " time(s).");
            }


            if (count>=3) {
                dice1.setDisable(true);
                dice2.setDisable(true);
                dice3.setDisable(true);
                dice4.setDisable(true);
                dice5.setDisable(true);
                rollButton.setDisable(true);
                //result.setText("You can't roll anymore.");
                if ((die1== die2 && die2== die3) || (die2 == die3 && die4 == die3) || (die2 == die1 && die5 == die1) ||(die3 == die1 && die5 == die1) || (die3 == die4 && die5 == die3) || (die1 == die4 && die5 == die1) || (die4 == die3 && die4 == die1) || (die5== die2 && die2== die4) ||
                        (die5== die2 && die2== die3))
                    result.setText("Three of a kind");
                if (die1== die2 && die2== die3 && die3 == die4 && die4 == die5)
                    result.setText("Yahtzee");
                if((die1== die2 && die2== die3 && die3 == die4) || (die1== die2 && die2== die3 && die3 == die5) || (die1== die4 && die4== die3 && die3 == die5) || (die4== die2 && die2== die3 && die3 == die5))
                    result.setText("Four of a kind");
                if ((die1 == die2 && die3 == die4 && die4 == die5) ||(die3 == die4 && die1 == die2 && die2 == die5) || (die1 == die5 && die3 == die4 && die4 == die2) || (die4 == die5 && die3 == die2 && die2 == die1) || (die1 == die4 && die2 == die3 && die3 == die5) || (die1 == die3 && die2 == die4 && die4 == die5) ||
                        (die3 == die2 && die1 == die4 && die4 == die5) || (die4 == die2 && die3 == die1 && die1 == die5) || (die5 == die2 && die3 == die4 && die4 == die1) || (die3 == die5 && die2 == die4 && die4 == die1))
                    result.setText("Full House");
                if (dieArray())
                    result.setText("Large Straight");
                if(isSmallStraight())
                    result.setText("Small Straight");


            }
        });

        Label game= new Label("Yahtzee");
        game.setFont(new Font("Aharoni", 42));
        BorderPane root = new BorderPane();
        root.setCenter(game);

        GridPane rot = new GridPane();
        rot.setPadding(new Insets(11.5,12.5,13.5,14.4));
        rot.setHgap(5.5);
        rot.setVgap(5.5);
        rot.add(layout, 0,0);
        rot.add(pickOrder,0,1);
        rot.add(rollButton,0,2);
        rot.add(result,1,2);
        rot.add(root,0, 3);

        stage.setScene(new Scene(rot));
        stage.show();

    }

    /**
     * Roll the dice by starting an animation that randomizes
     * the values on the dice in each frame.  The animation will
     * last for 60 frames, and the rollButton is disabled while
     * the animation is in progress.  This method is called
     * when the user clicks the roll button.
     */
    private void roll() {
        frameNumber = 0;
        rollButton.setDisable(true);
        timer.start(); // start an animation
    }


    private void drawDie(GraphicsContext g, int val, int x, int y) {
        g.setFill(Color.WHITE);
        g.fillRect(x, y, 50, 50);
        g.setStroke(Color.BLACK);
        g.strokeRect(x+0.5, y+0.5, 49, 49);
        g.setFill(Color.BLACK);
        if (val > 1)  // upper left dot
            g.fillOval(x+3, y+3, 10, 10);
        if (val > 3)  // upper right dot
            g.fillOval(x+34, y+3, 10, 10);
        if (val == 6) // middle left dot
            g.fillOval(x+3, y+19, 10, 10);
        if (val % 2 == 1) // middle dot (for odd-numbered val's)
            g.fillOval(x+19, y+19, 10, 10);
        if (val == 6) // middle right dot
            g.fillOval(x+34, y+19, 10, 10);
        if (val > 3)  // bottom left dot
            g.fillOval(x+3, y+34, 10, 10);
        if (val > 1)  // bottom right dot
            g.fillOval(x+34, y+34, 10,10);
    }

    //Dice images
    public void draw(){
        GraphicsContext g = layout.getGraphicsContext2D();
        drawDie(g,die1,12,12);
        drawDie(g,die2,94,12);
        drawDie(g,die3,176,12);
        drawDie(g,die4,258,12);
        drawDie(g,die5,340,12);

    }

    private boolean dieArray(){
        int[] arr = new int[]{die1,die2,die3,die4,die5};
        boolean flag = false;
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        if (max - min + 1 == arr.length){
            boolean[] visited=new boolean[arr.length];
            for (int i = 0; i < arr.length; i++)
            {
                if (visited[arr[i] - min])
                    return flag;

                visited[arr[i] - min] = true;
            }
            flag = true;
        }
        return flag;
    }

    private boolean isSmallStraight() {
        int [] numbers = new int[]{die1,die2,die3,die4,die5};
        int[] resolver = sortNumbers(numbers);
        Arrays.sort(resolver);

        return ((resolver[5] == resolver[4] + 1) && (resolver[4] == resolver[3] + 1)
                && (resolver[3] == resolver[2] + 1));

    }

    private int[] sortNumbers(int[] die) {

        int numberOne = 0, numberTwo = 0, numberThree = 0, numberFour = 0,
                numberFive = 0, numberSix = 0;


        for (int i = 0; i < die.length; i++) {
            if (die[i] == 1) numberOne++;
            if (die[i] == 2) numberTwo++;
            if (die[i] == 3) numberThree++;
            if (die[i] == 4) numberFour++;
            if (die[i] == 5) numberFive++;
            if (die[i] == 6) numberSix++;

        }
        return new int[] {numberOne, numberTwo, numberThree, numberFour,
                numberFive, numberSix};

    }

}
