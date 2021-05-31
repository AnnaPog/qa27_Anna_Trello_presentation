package com.anna.trello.model;

public class Board {
    private String boardName;
    private String visibility;

//    public Board(String boardName, String visibility) {
//        this.boardName = boardName;
//        this.visibility = visibility;
//    }

    public Board setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board setVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    public String withBoardName() {
        return boardName;
    }

    public String withVisibility() {
        return visibility;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardName='" + boardName + '\'' +
                ", visibility='" + visibility + '\'' +
                '}';
    }
}
