package com.team13.piazzapanic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import jdk.jfr.internal.tool.Main;


public class HUD implements Disposable {
    public Stage stage;
    private Boolean scenarioComplete;

    private Integer worldTimerM;
    private Integer worldTimerS;

    private Integer money;

    //public static boolean getMoney(){
    //    return (money);
    //}

    public Integer reputationPoints;
    public String timeStr;

    public Table table;

    Label timeLabelT;
    Label timeLabel;
    Label scoreLabel;
    Label scoreLabelT;
    Label moneyLabel;
    Label moneyLabelLT;
    Label orderNumL;
    Label orderNumLT;
    Label reputationLabelT;
    Label reputationLabel;

    public HUD(SpriteBatch sb){
        this.scenarioComplete = Boolean.FALSE;
        worldTimerM = 0;
        worldTimerS = 0;
        money = 0;
        reputationPoints = 3;
        timeStr = String.format("%d", worldTimerM) + " : " + String.format("%d", worldTimerS);
        float fontX = 0.5F;
        float fontY = 0.3F;

        BitmapFont font = new BitmapFont();
        font.getData().setScale(fontX, fontY);
        Viewport viewport = new FitViewport(MainGame.V_WIDTH, MainGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        table = new Table();
        table.left().top();
        table.setFillParent(true);

        timeLabel = new Label(String.format("%d", worldTimerM, ":", "%i", worldTimerS), new Label.LabelStyle(font, Color.WHITE));
        timeLabelT = new Label("TIME", new Label.LabelStyle(font, Color.BLACK));
        orderNumLT = new Label("ORDER", new Label.LabelStyle(font, Color.BLACK));
        orderNumL = new Label(String.format("%d", 1), new Label.LabelStyle(font, Color.WHITE));

        moneyLabel = new Label(String.format("%d", money), new Label.LabelStyle(font, Color.WHITE));
        moneyLabelLT = new Label("MONEY", new Label.LabelStyle(font, Color.BLACK));

        if (MainGame.GameMode == MainGame.Mode.ENDLESS) {
            reputationLabelT = new Label("REPUTATION", new Label.LabelStyle(font, Color.BLACK));
            reputationLabel = new Label(String.format("%d", reputationPoints), new Label.LabelStyle(font, Color.WHITE));
        }

        table.add(timeLabelT).padTop(2).padLeft(2);
        table.add(moneyLabelLT).padTop(2).padLeft(2);
        table.add(orderNumLT).padTop(2).padLeft(2);
        if (MainGame.GameMode == MainGame.Mode.ENDLESS){
            table.add(reputationLabelT).padTop(2).padLeft(2);
        }
        table.row();
        table.add(timeLabel).padTop(2).padLeft(2);
        table.add(moneyLabel).padTop(2).padLeft(2);
        table.add(orderNumL).padTop(2).padLeft(2);
        if (MainGame.GameMode == MainGame.Mode.ENDLESS){
            table.add(reputationLabel).padTop(2).padLeft(2);
        }


        table.left().top();
        stage.addActor(table);
    }

    /**
     * Updates the time label.
     *
     * @param scenarioComplete Whether the game scenario has been completed.
     */
    public void updateTime(Boolean scenarioComplete){
        if((MainGame.GameMode == MainGame.Mode.SITUATION) && (scenarioComplete==Boolean.TRUE)){
            timeLabel.setColor(Color.GREEN);
            timeStr = String.format("%d", worldTimerM) + ":" + String.format("%d", worldTimerS);
            timeLabel.setText(String.format("TIME: " + timeStr + " MONEY: %d", money));
            timeLabelT.setText("SCENARIO COMPLETE");
            table.center().top();
            stage.addActor(table);
            return;
        }
        else if (PlayScreen.endlessOver == Boolean.TRUE){
            timeLabel.setColor(Color.BLACK);
            timeLabelT.setColor(Color.RED);
            timeStr = String.format("%d", worldTimerM) + ":" + String.format("%d", worldTimerS);
            timeLabel.setText(String.format("TIME: " + timeStr + " MONEY: %d", money));
            timeLabelT.setText("GAME OVER");
            table.center().top();
            stage.addActor(table);
            moneyLabel.setColor(Color.GREEN);
            moneyLabel.setText("");
            moneyLabelLT.setText("");
            moneyLabelLT.remove();
            moneyLabel.remove();
            table.center().top();
            stage.addActor(table);
            orderNumL.remove();
            orderNumLT.remove();
            table.center().top();
            stage.addActor(table);
            reputationLabel.remove(); //ReputationNumL should be used here when implemented
            reputationLabelT.remove(); //ReputationNumLT should be used here when implemented
            table.center().top();
            stage.addActor(table);
            return;
        }
        else {
            if (worldTimerS == 59) {
                worldTimerM += 1;
                worldTimerS = 0;
            } else {
                worldTimerS += 1;
            }
        }
        table.left().top();
        if(worldTimerS < 10){
            timeStr = String.format("%d", worldTimerM) + ":0" + String.format("%d", worldTimerS);
        }
        else {
            timeStr = String.format("%d", worldTimerM) + ":" + String.format("%d", worldTimerS);
        }
        timeLabel.setText(timeStr);
        if (MainGame.GameMode == MainGame.Mode.ENDLESS){
            reputationLabel.setText(reputationPoints);
        }
        stage.addActor(table);

    }

    /**
     * Calculates the user's score per order and updates the label.
     *
     * @param scenarioComplete Whether the game scenario has been completed.
     * @param expectedTime The expected time an order should be completed in.
     */
    public void updateScore(Boolean scenarioComplete, Integer expectedTime){
        int addScore;
        int currentTime;

        if(this.scenarioComplete == Boolean.FALSE){
            currentTime = (worldTimerM * 60) + worldTimerS;
            if (currentTime <= expectedTime) {
                addScore = 100;
            }
            else{
                addScore = 100 - (5 * (currentTime - expectedTime));
                if(addScore < 0){
                    addScore = 0;
                }
            }
            money += addScore;
        }


        if (scenarioComplete==Boolean.TRUE) {
            moneyLabel.setColor(Color.GREEN);
            moneyLabel.setText("");
            moneyLabelLT.setText("");
            moneyLabelLT.remove();
            moneyLabel.remove();
            table.center().top();
            stage.addActor(table);
            this.scenarioComplete = Boolean.TRUE;
            return;
        }

        table.left().top();
        moneyLabel.setText(String.format("%d", money));
        stage.addActor(table);

    }

    public boolean purchaseUnlock() {
        int upgradeCost = 50;
        if (money - upgradeCost >= 0) {
            money -= upgradeCost;
            table.left().top();
            moneyLabel.setText(String.format("%d", money));
            stage.addActor(table);
            return true;
        } else {
            return false;
        }
    }
    public void addMoney(int addMoney) {
        money += addMoney;
        table.left().top();
        moneyLabel.setText(String.format("%d", money));
        stage.addActor(table);
    }

    /**
     * Updates the order label.
     *
     * @param scenarioComplete Whether the game scenario has been completed.
     * @param orderNum The index number of the order.
     */

    // Scenario isn't the only way to play, there is an endless mode to be implemented as well.
    // In this case scenario should be set to false always in endless mode for versions of this call to work. -Jonathon
        public void updateOrder(Boolean scenarioComplete, Integer orderNum) {
            if(scenarioComplete==Boolean.TRUE){
                orderNumL.remove();
                orderNumLT.remove();
                table.center().top();
                stage.addActor(table);
                return;
            }

            table.left().top();
            orderNumL.setText(String.format("%d", orderNum));
            orderNumLT.setText("ORDER");
            stage.addActor(table);

        }

    // needs to fail the game if the reputation hits 0.
    public void updateReputation(Integer reputationNum){
        if(reputationNum <= 0){
            //reputationLabel.remove(); //ReputationNumL should be used here when implemented
            //reputationLabelT.remove(); //ReputationNumLT should be used here when implemented
            //table.center().top();
            //stage.addActor(table);

        }
        else {
            table.left().top();
            reputationPoints = reputationNum;
            reputationLabel.setText(String.format("%d", reputationNum));
            reputationLabelT.setText("REPUTATION");
            stage.addActor(table);
        }
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
