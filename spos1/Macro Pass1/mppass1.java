import java.io.*;

public class mppass1 {
    public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\harsh\\OneDrive\\Desktop\\MyCodes\\SPOS 5\\Macro Pass1\\input.txt"));
    String line;
    mdt[] MDT = new mdt[20];
    mnt[] MNT = new mnt[4];
    arglist[] ARGLIST = new arglist[10];
    boolean macro_start= false, macro_end= false, fill_arglist= false;
    int mdt_cnt=0, mnt_cnt = 0, arglist_cnt=0;
    while((line = br1.readLine())!= null){
        line = line.replaceAll(",", " ");
        String[] tokens = line.split("\\s+");
        MDT[mdt_cnt] = new mdt();
        String stmt ="";
        for(int i =0;i<tokens.length;i++){
            if(tokens[i].equalsIgnoreCase("mend"))
            {
                MDT[mdt_cnt++].stmt = "\t"+tokens[i];
                macro_end = true;
            }
            if(tokens[i].equalsIgnoreCase("macro"))
            {
                macro_start= true;
                macro_end= false;
            }
            else if (! macro_end)
            {
                if(macro_start)
                {
                    MNT[mnt_cnt++]= new mnt(tokens[i], mdt_cnt);
                    macro_start= false;
                    fill_arglist= true;
                }
                if(fill_arglist)
                {
                    while(i<tokens.length){
                        MDT[mdt_cnt].stmt = MDT[mdt_cnt].stmt + "\t" + tokens[i];
                        stmt = stmt + "\t" + tokens[i];
                        if(tokens[i].matches("&[a-zA-Z]+")||tokens[i].matches("&[a-zA-Z]+ [0-9]+"))
                            ARGLIST[arglist_cnt++]= new arglist(tokens[i]);
                        i++;
                    }
                    fill_arglist=false;
                }
                else
                {
                     if(tokens[i].matches("&[a-zA-Z]+")||tokens[i].matches("&[a-zA-Z]+ [0-9]+"))
                     {
                        MDT[mdt_cnt].stmt = MDT[mdt_cnt].stmt+ "\t"+ tokens[i];
                        stmt = stmt + "\t"+ tokens[i];
                     }
                    if(tokens[i].matches("&[a-zA-Z]+")||tokens[i].matches("&[a-zA-Z]+ [0-9]+"))
                    {
                        for(int j=0;j<arglist_cnt; j++)
                            if(tokens[i].equals(ARGLIST[j].argname))
                            {
                                MDT[mdt_cnt].stmt = MDT[mdt_cnt].stmt + "\t#"+(j+1);
                                stmt = stmt + "\t#"+ (j+1); 
                            }
                    }
                }
            }
        }
        if(stmt!="" && !macro_end)
            mdt_cnt++;
    }
    br1.close();

    BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:\\Users\\harsh\\OneDrive\\Desktop\\MyCodes\\SPOS 5\\Macro Pass1\\mnt.txt"));
    System.out.println("\n\t----------MACRO NAME TABLE----------");
    System.out.println("\n\tINDEX\tNAME\tADDRESS");
    for(int i=0;i<mnt_cnt;i++)
    {
        System.out.println("\t"+ i+"\t"+MNT[i].name+"\t"+ MNT[i].addr);
        bw1.write(MNT[i].name+"\t"+ MNT[i].addr+"\n");  
    }
    bw1.close();

    bw1 = new BufferedWriter(new FileWriter("C:\\Users\\harsh\\OneDrive\\Desktop\\MyCodes\\SPOS 5\\Macro Pass1\\arglist.txt"));
    System.out.println("\n\t----------ARGUMENT LIST----------");
    System.out.println("\n\tINDEX\tNAME");
    for(int i=0;i<arglist_cnt;i++)
    {
        System.out.println("\t"+ i+"\t"+ARGLIST[i].argname);
        bw1.write(ARGLIST[i].argname+"\n");  
    }
    bw1.close();

    bw1 = new BufferedWriter(new FileWriter("C:\\Users\\harsh\\OneDrive\\Desktop\\MyCodes\\SPOS 5\\Macro Pass1\\mdt.txt"));
    System.out.println("\n\t----------MACRO DEFINATION TABLE----------");
    System.out.println("\n\tINDEX\t\t\tSTATEMENT");
    for(int i=0;i<mdt_cnt;i++)
    {
        System.out.println("\t"+ i+"\t"+MDT[i].stmt);
        bw1.write(MDT[i].stmt+"\n");  
    }
    bw1.close();
    }
}

