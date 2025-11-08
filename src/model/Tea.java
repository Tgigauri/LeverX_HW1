package model;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class Tea {

    private String teaName;
    private int brewTime;

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getBrewTime() {
        return brewTime;
    }

    public void setBrewTime(int brewTime) {
        this.brewTime = brewTime;
    }


    public Tea(String teaName, int brewTime) {
        this.teaName = teaName;
        this.brewTime = brewTime;
    }

    public class InnerCountdown {
        public void startCountdown() {
            Runnable printer = new Runnable() {
                @Override
                public void run() {
                    AnsiConsole.systemInstall();
                    for (int i = brewTime; i > 0; i--) {
                        System.out.println(Ansi.ansi().fgYellow().a("Time left: " + i + " seconds").reset());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Ansi.ansi().fgGreen().a("Done! Enjoy your " + teaName).reset());
                    AnsiConsole.systemUninstall();
                }
            };
            printer.run();
        }
    }
}
