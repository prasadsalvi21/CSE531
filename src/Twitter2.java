import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Twitter2
{
public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate){
Iterator itr = logLines.iterator();
        Collection<String> result=new ArrayList<String>();
        Object s;
        while(itr.hasNext())
            {
            s=itr.next();
            String a=new String();
            a=s.toString();
            if(a.contains("2016"))
                {
            a=a.substring(0,20);
            
            //System.out.print(a);
            DateTimeFormatter formatter=DateTimeFormatter.ISO_DATE_TIME;
            LocalTime check=LocalTime.parse(a,formatter);
            if(check.equals(startDate)||(check.isAfter(startDate)&&check.isBefore(endDate)))
                {
                result.add(s.toString());
                System.out.println(a.toString());
            }
            }
            else{
            result.add(a.toString());
            }
        }
        if(result.isEmpty())
            return null;
        else
        return result;
        
    }
}