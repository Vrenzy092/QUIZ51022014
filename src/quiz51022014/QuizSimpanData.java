/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz51022014;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;


/**
 *
 * @author kiyoshi
 */
public class QuizSimpanData {
    int L=0, TL=0;
    public void SimpanD(String nim, String nama, String NilaiTugas, String NilaiQuiz, String NilaiMid, String NilaiFinal, String NilaiAkhir, String Nhuruf){
        try{
            FileOutputStream fout=new FileOutputStream("QUIZ51022014.dat",true);
            DataOutputStream out=new DataOutputStream(fout);
            out.writeUTF(nim);
            out.writeUTF(nama);
            out.writeUTF(NilaiTugas);
            out.writeUTF(NilaiQuiz);
            out.writeUTF(NilaiMid);
            out.writeUTF(NilaiFinal);
            out.writeUTF(NilaiAkhir);
            out.writeUTF(Nhuruf);
            out.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        
    }   
    
     public String ReadData(){
        String nim,nama,NilaiTugas,NilaiQuiz,NilaiMid,NilaiFinal,NilaiAkhir,Nhuruf;
        String temp="",data="";
        try{
            FileInputStream fin=new FileInputStream("QUIZ51022014.dat");
            DataInputStream in=new DataInputStream(fin);
          
            while (in.available()>0){
                nim=in.readUTF();
                nama=in.readUTF();
                NilaiTugas=in.readUTF();
                NilaiQuiz=in.readUTF();
                NilaiMid=in.readUTF();
                NilaiFinal=in.readUTF();
                NilaiAkhir=in.readUTF();     
                Nhuruf=in.readUTF();  
                if (Nhuruf.equals("D")){
                    TL++;
                }
                else if (Nhuruf.equals("E")){
                    TL++;
                }else {
                    L++;
                }
                temp="nim= "+nim+"\n nama= "+nama+"\n tugas= "+NilaiTugas+"\n quiz= "+NilaiQuiz+"\n mid= "+NilaiMid+"\n nilai final= "+NilaiFinal+"\n nilai akhir= "+NilaiAkhir+"\n nilai huruf="+Nhuruf+"\n ";  //bentuk string
                data+=temp; //masukkan setiap data ke string akhir
            }                              
            in.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return(data);
    }
    public int getL(){
        return L;
    }
     public int getTL(){
        return TL;
    }
}
