package com.viettran;

interface CharacterLevelState {
    String getName();
    void train(Character context);
    void mediate(Character context);
    void fight(Character context);
    void getAvailableActions();
}
