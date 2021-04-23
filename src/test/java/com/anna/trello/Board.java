package com.anna.trello;

public class Board {
    private String boardName;
    private String visibility;

    public Board(String boardName, String visibility) {
        this.boardName = boardName;
        this.visibility = visibility;
    }

    public String withBoardName() {
        return boardName;
    }

    public String withVisibility() {
        return visibility;
    }
}
