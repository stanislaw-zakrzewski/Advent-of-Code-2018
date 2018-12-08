class Worker {
    private Step actualStep;
    private int timeToFinish;

    void updateTime() {
        timeToFinish--;
    }

    Step getActualStep() {
        return actualStep;
    }

    int getTimeToFinish() {
        return timeToFinish;
    }

    void setActualStep(Step actualStep) {
        if (actualStep != null) {
            this.actualStep = actualStep;
            timeToFinish = 60 + (int) (actualStep.getName()) - 64;
        }
    }
}
