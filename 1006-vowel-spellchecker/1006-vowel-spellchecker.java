class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet <String> exact = new HashSet<>();
        Map<String , String> caseSensy = new HashMap<>();
        Map<String , String> consonant = new HashMap<>();

        for(String word : wordlist) {
            exact.add(word);
            caseSensy.putIfAbsent(word.toLowerCase() , word);
            consonant.putIfAbsent(devowel(word.toLowerCase()) , word);
        }

        String[] res = new String[queries.length];
        int i = 0;

        for(String query : queries) {
            if(exact.contains(query)) res[i] = query;
            else if(caseSensy.containsKey(query.toLowerCase())) {
                res[i] = caseSensy.get(query.toLowerCase());
            }
            else if(consonant.containsKey(devowel(query.toLowerCase()))) {
                res[i] = consonant.get(devowel(query.toLowerCase()));
            }
            else res[i] = "";
            i++;
        }
        return res;
    }
    public String devowel(String str) {
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()) {
            sb.append(isVowel(c) ? "*" : c);

        }
        return sb.toString();
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    } 
}
