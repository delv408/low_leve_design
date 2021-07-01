package com.practice.snakeladder;

public class Game {

    private Board board;
    private Dice dice;
    // todo players as array
    private Player player1;
    private Player player2;
    private String state;

    public Game(Board board, Dice dice, Player player1, Player player2) {
        this.board = board;
        this.dice = dice;
        this.player1 = player1;
        this.player2 = player2;
        this.state = "Ready";
        System.out.println("Game is all set");
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void play(){
        Player[] players = {player1, player2};
        state = "In Play";
        while(state != "Finished"){
            for(Player player :players){
                System.out.println(String.format("Player: %s rolling...", player.getName()));
                int draw = dice.diceThrow();
                if(player.goti.position + draw == board.getSize()){
                    player.moveGotiBy(draw);
                    state = "Finished";
                    System.out.println(state);
                    System.out.println(String.format("Player %s won!!", player.name));
                    break;
                }
                if(player.goti.position + draw <= board.getSize()){
                    player.moveGotiBy(draw);


                    int snakeCheck = board.isSnake(player.goti.position);
                    if( snakeCheck != 0){
                        System.out.println("No no no!! Found Snake");
                        player.moveGoti(snakeCheck);
                    }
                    int ladderCheck = board.isLadder(player.goti.position);
                    if(ladderCheck != 0){
                        System.out.println("Yeah!! Found Ladder");
                        player.moveGoti(ladderCheck);
                    }
                }
                else{
                    System.out.println("No Valid move");
                }
            }
        }
    }
}
