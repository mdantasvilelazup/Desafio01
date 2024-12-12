public class GameData {
    private int score = 0;
    private int target = 0;
    public int difficulty = 0;
    
    public int getScore() { return score; }
    public int getTarget() { return target; }

    public int guess(int num) {
        if(num == target) {
            score += 10;
            return 10;
        }
        if(num + 1 == target || num - 1 == target) {
            score += 5;
            return 5;
        }

        return 0;
    }

    public void resetTarget() {
        switch (difficulty) {
            case 1:
                target = genRand(10);
                break;
            case 2:
                target = genRand(50);
                break;
            case 3:
                target = genRand(100);
                break;
            default:
                break;
        }
    }

    private int genRand(int range) {
        return (int)(Math.random() * range + 1);
    }
}
