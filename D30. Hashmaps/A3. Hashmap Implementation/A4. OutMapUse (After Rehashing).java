
public class OurMapUse {

	public static void main(String[] args) {

		//maine apna map banaya and mai 20 entries dal rha hu
		Map<String, Integer>map= new Map<>();
		for(int i=0; i<20 ; i++) {
			map.insert("abc"+ i, 1+i); //pure map mai = abc 1, abc 2, abc 3 aise store hoga. These are the values that I'm putting in.
			System.out.println("i= "+ i + " lf = "+ map.loadFactor());//mai print kr rha hu load factor kaise kaise change ho rha hai
			//Map class mai numBuckets ko 5 kardiya 20 ki jagah. So ab 4th entry dalte hi rehash hogi, 10 hojayegi buckets
		}
		
			
		map.removeKey("abc3"); //output mai abc3 ke corresponding null ayega coz hume getValue kithi abc3 ke corresponding but delete hogya hai isliye null dega
		map.removeKey("abc7");
		
		for( int i=0; i< 20; i++) {
			System.out.println("abc" + i + ":" + map.getValue("abc" + i));
			//kya kya values insert hui hai mere map mai yeh print karega
			// it'll print: abc 0 ke corresponging 1 gya hai....and abc 19 ke corresponding 20 gya hai
		}
	}

}


Output:
//First loop ka output:
	i= 0 lf = 0.2 //(i ki value zero hogyi hai that  means pehli entry ja chuki hai and load factor 0.2 hogya(size is 1 and number of buckets is 5: 1/5= 0.2))
	i= 1 lf = 0.4 
	i= 2 lf = 0.6
	Rehashing : buckets : 5 size : 4 //(4th entry jatehi humara load factor 0.8 hojayega, so woh 0.7 se jada hai so rehash hojayega) (load factor: 4/5= 0.8)
	i= 3 lf = 0.4 //rehashing hone ke bad jo load factor print kiya hai woh 0.4 ho chuka hai because numBuckets 10 ho chuki hai aur entries humare pas 4 hai so load factor has came down to 0.4
	i= 4 lf = 0.5
	i= 5 lf = 0.6
	i= 6 lf = 0.7
	Rehashing : buckets : 10 size : 8
	i= 7 lf = 0.4
	i= 8 lf = 0.45
	i= 9 lf = 0.5
	i= 10 lf = 0.55
	i= 11 lf = 0.6
	i= 12 lf = 0.65
	i= 13 lf = 0.7
	Rehashing : buckets : 20 size : 15
	i= 14 lf = 0.375
	i= 15 lf = 0.4
	i= 16 lf = 0.425
	i= 17 lf = 0.45
	i= 18 lf = 0.475
	i= 19 lf = 0.5

//Second Loop ka output:
abc0:1
abc1:2
abc2:3
abc3:null //abc3 ke corresponding null diya hai coz yeh delete ho chuka hai
abc4:5
abc5:6
abc6:7
abc7:null //abc7 ke corresponding null diya hai coz yeh delete ho chuka hai
abc8:9
abc9:10
abc10:11
abc11:12
abc12:13
abc13:14
abc14:15
abc15:16
abc16:17
abc17:18
abc18:19
abc19:20

