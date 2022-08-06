//public class IndexOf
//{
//    public int strStr(final String haystack,
//                      final String needle)
//    {
//        char[] haystackArr     = haystack.toCharArray();
//        char[] needleArr       = needle.toCharArray();
//        int    haystackPointer = 0;
//        int    needlePointer   = 0;
//        int    firstCharMatch  = 0;
//
//        if(needleArr.length > haystackArr.length)
//        {
//            return - 1;
//        }
//
//        while(haystackArr.length - haystackPointer >= needleArr.length || // there's still space in haystack to contain the needle
//                needlePointer > needle.length() - 1)                      //
//        {
//            if(needleArr[needlePointer] != haystackArr[haystackPointer])
//            {
//                if(haystackPointer == 0)
//                {
//                    haystackPointer++;
//                }
//                else
//                {
//                    needlePointer = 0;
//                    haystackPointer++;
//                }
//            }
//            else
//            {
//                if(needlePointer == 0 && haystackArr[firstCharMatch] != haystackArr[haystackPointer])
//                {
//                    firstCharMatch = haystackPointer;
//                }
//
//                haystackPointer++;
//
//                if(needlePointer < needleArr.length - 1)
//                {
//                    needlePointer++;
//                }
//            }
//        }
//        //
//        //        if(needlePointer == 0 &&                                            // needlePointer still at
//        //        beginning
//        //                haystackPointer > haystackArr.length - needleArr.length &&  //
//        //                haystackArr.length > 1 &&                                   // elim  a,a
//        //                needleArr.length > 1)                                       // elim a,a / abc,c / aaa,a
//        //        {
//        //            return - 1;
//        //        }
//
//        if()
//        {
//            return firstCharMatch;
//        }
//    }
//
//    public static void main(final String[] args)
//    {
//        IndexOf obj = new IndexOf();
//        System.out.println(obj.strStr("hello", "ll"));  // should output 2
//        System.out.println(obj.strStr("aaaaa", "bba")); // should output -1
//        System.out.println(obj.strStr("a", "a")); // should output 0
//        System.out.println(obj.strStr("abc", "c")); // should output 2
//        System.out.println(obj.strStr("aaa", "a")); // should output 0
//        System.out.println(obj.strStr("mississippi", "a")); // should output -1
//    }
//}
