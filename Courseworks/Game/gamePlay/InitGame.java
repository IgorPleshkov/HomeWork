package Courseworks.Game.gamePlay;

public class InitGame {
    private static StructureGame structureGame = new StructureGame();

    public static void initGame(){
        StepGame level1 = new StepGame("Лисенок", "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. " +
              "Это утро не было исключением. \nЛисёнок пришёл на их обычное место встречи, но Бельчонка там не было. \nЛисёнок ждал, ждал, но так и не " +
              "смог дождаться своего друга.\n \"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. \nКак поступить " +
              "Лисенку?"
           , false, true);

        StepGame level2 = new StepGame("Вернуться домой", "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место " +
                "встречи раньше и увидел там рой злобных пчел. \nОн поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга! " +
                "\nИгра завершилась успехом",
                true, false);

        StepGame level3 = new StepGame("Отправиться на поиски", "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. " +
                "\nНо вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. \nПомогите ему."
                , false, false);

        StepGame level4 = new StepGame("Попытаться разузнать о Бельчонке у лесных жителей", "Пока Лисёнок принимал решение, лесные жители разошлись кто куда. " +
                "Остались только Сова и Волк. \nНо у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. \nКого выбрать?"
                , false, false);


        StepGame level5 = new StepGame("Искать Бельчонка в одиночку", "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился." +
                "\nТеперь его самого нужно искать. \nИгра завершилась неудачей"
                , false, false);

        StepGame level6 = new StepGame("Расспросить Сову", "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего " +
                "в глубь леса. \nВсе лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь."
                , false, false);

        StepGame level7 = new StepGame("Расспросить Волка", "Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не " +
                "стоит бродить по лесу одному. \nИ как теперь поступить?"
                , false, false);

        StepGame level8 = new StepGame("Поверить Сове и отправиться в глубь леса", "В глубине леса Лисёнок встретил Медвежонка. \nЛенивый Медвежонок был готов" +
                "рассказать все, что знает, если Лисёнок принесёт ему мёда."
                , false, false);

        StepGame level9 = new StepGame("Нужно воспользоваться шансом и раздобыть мёд", "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. \nЛисёнок всегда " +
                "боялся пчёл, но и не найти друга он тоже боялся."
                , false, false);

        StepGame level10 = new StepGame("Подождать, вдруг пчёлы улетят", "Лисёнок подождал немного, и пчёлы разлетелись. " +
                "\nЛисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден. Что же делать?"
                , false, false);

        StepGame level11 = new StepGame("Нужно попытаться выкрасть мёд немедленно", "Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь. " +
                "\nИгра закончилась неудачей"
                , false, false);

        StepGame level12 = new StepGame("Поесть немного и передохнуть", "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. " +
                "\nЛисёнку нужна помощь, он не сможет продолжить поиски. Игра завершилась неудачей"
                , false, false);

        StepGame level13 = new StepGame("Скорее отнести мёд Медвежонку", "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, " +
                "\nчто Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, и что Совам нельзя верить, он также уговаривал " +
                "\nЛисёнка вернуться домой."
                , false, false);

        level1.setNextStep(1, level2); level1.setNextStep(2, level3);
        level3.setNextStep(1, level4); level3.setNextStep(2, level5);
        level4.setNextStep(1, level6); level4.setNextStep(2, level7);
        level6.setNextStep(1, level8); level6.setNextStep(2, level5);
        level7.setNextStep(1, level2); level7.setNextStep(2, level5);
        level8.setNextStep(1, level5); level8.setNextStep(2, level9);
        level9.setNextStep(1, level10); level9.setNextStep(2, level11);
        level10.setNextStep(1, level12); level10.setNextStep(2, level13);
        level13.setNextStep(1, level5); level13.setNextStep(2, level2);

        structureGame.addSteps(level1);
        structureGame.addSteps(level2);
        structureGame.addSteps(level3);
        structureGame.addSteps(level4);
        structureGame.addSteps(level5);
        structureGame.addSteps(level6);
        structureGame.addSteps(level7);
        structureGame.addSteps(level8);
        structureGame.addSteps(level9);
        structureGame.addSteps(level10);
        structureGame.addSteps(level11);
        structureGame.addSteps(level12);
        structureGame.addSteps(level13);

    }

    public static StructureGame getStructureGame() {
        return structureGame;
    }
}
