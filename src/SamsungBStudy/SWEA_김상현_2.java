package SamsungBStudy;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class SWEA_김상현_2
{
	private final static int CMD_INIT       = 100;
	private final static int CMD_INSERT     = 200;
	private final static int CMD_MOVECURSOR = 300;
	private final static int CMD_COUNT      = 400;
	
	private final static UserSolution usersolution = new UserSolution();
	
	private static void String2Char(char[] buf, String str, int maxLen)
	{
		for (int k = 0; k < str.length(); k++)
			buf[k] = str.charAt(k);
			
		for (int k = str.length(); k <= maxLen; k++)
			buf[k] = '\0';
	}
	
	private static char[] mStr = new char[90001];
	
	private static boolean run(BufferedReader br) throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int queryCnt = Integer.parseInt(st.nextToken());
		boolean correct = false;
		
		for (int q = 0; q < queryCnt; q++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == CMD_INIT)
			{
				int H = Integer.parseInt(st.nextToken());
				int W = Integer.parseInt(st.nextToken());
				
				String2Char(mStr, st.nextToken(), 90000);
				
				usersolution.init(H, W, mStr);
				correct = true;
			}
			else if (cmd == CMD_INSERT)
			{
				char mChar = st.nextToken().charAt(0);
				
				usersolution.insert(mChar);
			}
			else if (cmd == CMD_MOVECURSOR)
			{
				int mRow = Integer.parseInt(st.nextToken());
				int mCol = Integer.parseInt(st.nextToken());
				
				char ret = usersolution.moveCursor(mRow, mCol);
				
				char ans = st.nextToken().charAt(0);
				if (ret != ans)
				{
					System.out.println("틀림");
					correct = false;
				}
			}
			else if (cmd == CMD_COUNT)
			{
				char mChar = st.nextToken().charAt(0);
				
				int ret = usersolution.countCharacter(mChar);
				
				int ans = Integer.parseInt(st.nextToken());
				if (ret != ans)
				{
					System.out.println("틀림");
					correct = false;
				}
			}
		}
		return correct;
	}

	public static void main(String[] args) throws Exception
	{
		int TC, MARK;
		
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());
		
		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run(br) ? MARK : 0;
			
			System.out.println("#" + testcase + " " + score);
		}
		
		br.close();
	}
}

class UserSolution
{
	LinkedList<Character> mArr = new LinkedList<>();
	int[] cnt = new int[26];
	int row = 0;
	int col = 0;
	int height = 0;
	int width = 0;
	
	void init(int H, int W, char mStr[])
	{
		for(int i=0;i<mStr.length;i++) {
			if(mStr[i]<'a') {
				break;
			}
			mArr.add(mStr[i]);
		}
		row = 0;
		col = 0;
		width = W;
		height = H;
		for(int i=0;i<mArr.size();i++) {
			cnt[mStr[i]-'a']++;
		}
	}
	
	void insert(char mChar)
	{
		cnt[mChar-'a']++;
		if(row*width+col<mArr.size()) {
			mArr.add(row*width+col, mChar);
		}else {
			mArr.add(mChar);
		}
	}

	char moveCursor(int mRow, int mCol)
	{
		row = mRow-1;
		col = mCol-1;
		if(row*width+col<mArr.size()) {
			return mArr.get(row*width+col);
		}
		return '$';
	}
	int countCharacter(char mChar)
	{
		return cnt[mChar-'a'];
	}
}