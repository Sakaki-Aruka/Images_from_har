import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HarTest {
    public static void main(String[] args){
        String fileName = null;
        try{
            fileName = Files.readAllLines(Paths.get("harPath.txt")).get(0);
        }catch (Exception e){
            System.out.println("A target har file not found.");
            return;
        }

        List<String> lines = null;
        try{
            lines = Files.readAllLines(Paths.get(fileName));
        }catch (Exception e){
            System.out.println("File load error occurred.");
            return;
        }

        String string = String.join("+",lines);

        Pattern p = Pattern.compile("https://pbs.twimg.com/media/.{15}\\?format=.{1,5}&");
        Matcher matcher = p.matcher(string);

        while(matcher.find()){
            String url = matcher.group();
            url = url.replace("&","");

            Pattern p2 = Pattern.compile("\\?format=.{1,5}");
            Matcher m2 = p2.matcher(url);

            String extension="";
            while(m2.find()){
                extension = m2.group();
                url = url.replace(extension,"");
                extension = extension.replace("?format=","");
            }
            String img_string = url+"."+extension;
            System.out.println(img_string);

            String[] command = {"wget",img_string};
            ProcessBuilder pb = new ProcessBuilder(command);
            try{
                Process process = pb.start();
                process.waitFor();
            }catch (Exception e){
                System.out.println("download error occurred.");
            }
        }
    }
}
