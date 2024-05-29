package system;

import data.generators.IdGenerator;
import data.generators.MusicBandGenerator;
import network.Client;
import network.Request;
import scriptManager.ScriptManager;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String... args) throws SocketException, UnknownHostException {
        Client client = new Client();
        String cherepaha = "\n" +
                "                                         $p=\"ZCc!FTAb!TB\n" +
                "                                    BBb!CNIAa!ALMl!GICbncgb!J\n" +
                "                                Dzk!BIzedgb!Icsdua!Gznl!Ebxengd!\n" +
                "                              DaBlhfzBa!BAbCaAcrAfqCd!BafBbAbDdBdB\n" +
                "     bAiebCi!              AheAeiCnAdgf!AlBgAeDmBabjd!ibAaAAfAeFiECc\n" +
                "  k!          kA         bAeAaBaAfBbcdbBdn!baiAbBbHcDcgaAcp!AhbBcBaEBf\n" +
                " C              h      rd!AcgBcJfDeqdc!AaBgBAaLcFrhb!CAgPEDcubb!DgKKBte\n" +
                "a          c!D   A    fGedHsgb!EgFiGbbvb!EAgEBccHencdAa!GfAbJGbx!HdCeAGDd\n" +
                "o          Af!I   c  DaAaBcdDqBcAa!JcDaMfEaAcDa!KbNCe!XBABd!\";$q=\"FKIGHo!G\n" +
                "E          NJim    c!UEFteaf!NGEDyaj!DAhMAzo!BaaJbIoks!AaNaFzv!aACDBcCaDsgf\n" +
                "s                    !aJdCaBhrnla!aJdDzkod!aHKAhrijgc!aCaCaNgodza!AaCcNCnlz!\n" +
                "B   a   B              Xzpg!CbJPCzbigEc!EbRHBueuCa!GcMMAdvpFa!JbGSuehiCa!FDB\n" +
                " b   Zec                 iir!McCViqo!MdETnll!NcAbAOdaCmmeaCa!BMbAAAbaEIbCbCyF\n" +
                "  B                          a!PaDCajIaHdmHBa!CMaKaPaHDaDdCaIa!QaJcOaKdIaHa!LE\n" +
                "   aC                             GAaBfGbLaCIaGa!KDCaJaIeCaCHaALbDa!RaBHaLFaJa     Pc!\n" +
                "     Sa                            IaNCBaIa!ASbDBaAMEBcDb!UcCbVBcb!Xd!\";$r='$b=q=\"   =\n" +
                "       ;$c                           =q{$d=qq{\\44p=$b$p$b;\\44q=$b$q$b;\\44r=\\47$      r\n" +
                "          \\4                          7;eval(\\44r);};$d=~s/\\s//gs;$p=~s/\\s//gs;$i   =\n" +
                "            0;                          print(map{($l=$_%32)&&$_>92?substr($d,($i+=$\n" +
                "             l)-                         $l,$l):chr($_>63?32:10)x$l}unpack(q{C*},$\n" +
                "             p));                         };$c=~s/\\s//gs;eval$c;$b=\";eval(%w{d=%\n" +
                "              {\\4 4p                =\\42#   {$p}\\42;\\44q=\\42#{$q}\\42;\\44r=\\4   7\n" +
                "               #{   $r}              \\4   7;   eval(\\44r);}.gsub(/\\s/,%{        }\n" +
                "                )       ;i=0;$q.gsu         b        (/\\s/,%{}).each_b          y\n" +
                "                t           e                {            |    b|l=   b         %\n" +
                "                 3          2;p               r           int(         b        >\n" +
                "                 9           5  ?d[(i+       =l            )            -       l\n" +
                "                  ,          l         ]:(b>   6           3             ?3    2\n" +
                "                  :          1                  0          )                .ch\n" +
                "                   r         *                   l         )\n" +
                "                    }}      *                     %{}    );\n" +
                "                     #\";   ';                        eval(\n" +
                "                        $r);";
        String sout;
        String[] request;
        System.out.println("All commands that you can use:" + "\n");
        sout = client.callServer(new Request(new String[]{"help"}));
        if (sout == null){
            System.out.println("Server is temporarily unavailable");
            System.out.println(cherepaha);
            System.exit(0);
        }
        System.out.println(sout);
        System.out.println("You can start working");
        Scanner scanner = new Scanner(System.in);
        String command;
        while(true){
            int flag = 0;
            command = scanner.nextLine();
            request = command.split(" ");
            if(request[0].equals("add") || request[0].equals("remove_lower")){
                var band = MusicBandGenerator.createMusicBand(IdGenerator.generateId());
                sout = client.callServer(new Request(band, request));

            }
            else if(request[0].equals("update")){
                String[] data = {"check_id", request[1]};
                Request check = new Request(data);
                sout = client.callServer(check);
                if (sout.equals("1")) {
                    var band = MusicBandGenerator.createMusicBand(IdGenerator.generateId());
                    sout = client.callServer(new Request(band, request));
                }
            }
            else if(request[0].equals("exit")) {
                sout = "";
                System.out.println(cherepaha);
                System.exit(0);
            }
            else if(request[0].equals("execute_script") && request.length>1){
                ScriptManager.executeScript(request[1],new ArrayList<>(),client);
                flag = 1;
            }
            else {
                sout = client.callServer(new Request(request));
            }
            if (sout == null) {
                System.out.println("Error receiving the server response");
                System.out.println(cherepaha);
                System.exit(0);
            }
            else if (flag==0) System.out.println(sout);
        }

    }

}