package snowwhite;

import java.util.Random;

public class SnowWhite {

    private Factory factory;

    public void distributeWork(){
        for (int i = 0; i < factory.getPostBox().size(); i++) {
            Letter letter = factory.getPostBox().get(i);
            Dwarf dwarf = factory.getRandomWorker();
            if(letter.getOwner().isNaughty()){
                if(new Random().nextBoolean()){
                    dwarf.createPresent(letter.getPresents().get(0), letter.getOwner());
                }
                else{
                    factory.rejectKid();
                }
            }
            else{
                for (int j = 0; j < letter.getPresents().size(); j++) {
                    dwarf.createPresent(letter.getPresents().get(j), letter.getOwner());
                }
            }
        }
    }

    public void prepareSleigh(){
        //TODO
    }

    public void prepareReports(){
        factory.report1();
        factory.report2();
        factory.report3();
        factory.report4();
        factory.report5();
//        factory.report6();
        factory.report7();
//        factory.report8();
        factory.report9();
//        factory.report10();
        factory.report11();
//        factory.report12();
        factory.report13();
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
