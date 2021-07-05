package com.sist.main;
/*
 *  ����ó�� => ����Ǵ� ������ �����ؼ� ����� ���� (���������� ������ ����)
 *  ��)
 *        ����ڷκ��� ������ �޾Ƽ�
 *        �迭�� ������ ������ �ΰ� ������ �������� ���
 *        ==========                ==========
 * ����ex) �迭 - �ε��� �ʰ� ����       ����ڰ� 0���� �����޶�
 *        ===================      ===================
 *        catch�� 2���� �ִ� ==> try�Ѱ��� catch�� ������ ����� ����
 *               ��������
 *               ======
 *                       Object
 *                          |
 *                      Throwable
 *                          |
 *                     ===========
 *                     |         |     
 *                   Error     Exception (ó���� ������ �κ�)
 *                               |
 *                         ====================
 *                         | �ݵ�� ����ó��      |
 *                     (������ ����)        (����� ����)
 *                                       RuntimeException
 *                                            |
 *                                            ArrayIndexOutOfBoundsException // �迭
 *                                            ArithmeticException // 0���� ���� ��
 *                                            NumberFormatException
 *                     
 *        =======================================================
 *        
 *        try // catch 2�����
 *        {
 *        }catch(ArrayIndexOutOfBoundsException) �迭 �ε��� �ʰ�
 *        {
 *        }catch(ArithmeticException) ����ڰ� 0���� �����޶�
 *        {
 *        }
 *        
 *        =======================================================
 *        
 *        try // catch 1�� ���
 *        {
 *        }catch(RuntimeException) �迭 �ε��� �ʰ�, ����� 0
 *        
 *        =======================================================
 *        
 *        try // � �� ������� �� �� => Exception
 *        {
 *        }catch(Exception) �迭 �ε��� �ʰ�, ����� 0 (���ܿ� ���õ� ��� ������ ���� �� �ִ�)
 *        =======================================================
 *        
 *        try
 *        {
 *        }catch(Throwable) �迭 �ε��� �ʰ�, ����� 0
 *        
 *        =====
 *        try // ����
 *        {
 *           ���� ������ ������ �ҽ��ڵ� (���� �ڵ�)
 *        }catch(ArrayIndexOutOfBoundsException) // �迭
 *        {
 *        }catch(ArithmeticException) // ������
 *        {
 *        }catch(Exception) // ��Ÿ
 *        {
 *        }
 *        -------------------------------------------------
 *        try // ����
 *        {
 *           ���� ������ ������ �ҽ��ڵ� (���� �ڵ�)
 *        }catch(Exception) // ��Ÿ =====================> �ڡڡڡ� ������ ���� �ڡڡڡ�
 *        {
 *        }catch(ArrayIndexOutOfBoundsException) // �迭
 *        {
 *        }catch(ArithmeticException) // ������
 *        {
 *        }
 *        ==> catch�� �����ϴ� ����ó�� ������ �ڡڼ����ڡ� �� �ִ� (���� �� ==> ū ��) => ��������
 *        
 *        ==> try~catch�� ���� ����
 *        try
 *        {
 *           1. ���� = ����
 *           2. ���� = ����
 *           3. ���� = ����
 *           4. ���� = ����
 *           5. ���� = ����  ==> catch�� ����ؼ� ����
 *        }
 *        catch(Exception e)
 *        {
 *           6. ���� = ����
 *        }
 *        7. ����
 *        =====================> 1,2,3,4,5,7���� ����
 *        -------------------------------------------
 *        try
 *        {
 *           1. ���� = ����
 *           2. ���� = ����
 *           3. ���� = ����
 *        ==========================================================
 *           4. ���� = �����߻� ==> catch�̵�
 *           5. ���� = ����  ==> catch�̵��߱� ������ �����̵Ǵ� ������ �ƴϴ�
 *        ========================================================== ���� (Jump)
 *        }
 *        catch(Exception e)
 *        {
 *           6. ���� ==> ���� ���� ==> ����(������ġ Ȯ��)
 *           ==> �����޼��� ���
 *               ============
 *               getMessage() => /Zero
 *               printStackTrace() => ���� ��ġ Ȯ�� (����)
 *        }
 *        7. ����
 *        =====================> 1,2,3,6,7���� ���� �� ����
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.����");
		System.out.println("2.����"); // ���ܿ� ������ ���� => ������ �����ϴ� ����
		try {
			System.out.println("3.����");
//			int[] arr= {10,0}; 
			int[] arr= {10,5};
//			System.out.println(arr[0]/arr[2]); // ���� �߻� => �迭�� ���� �ʰ�
			System.out.println(arr[0]/arr[1]);
//			System.out.println(Integer.parseInt("a")); // ������ ��ȯ�� �ȵ�
			System.out.println(Integer.parseInt("30"));
//			MainClass2 m=null; // new�� �̿��ؼ� ��������� ����� (null ��������� ���� ����)
			MainClass2 m=new MainClass2();
			System.out.println(m.toString());
//			Object obj=new Object(); // Ŭ���� ����ȯ ����
			Object obj=new MainClass2();
			m=(MainClass2)obj;
			System.out.println(m);
//			����ȯ�ÿ��� �ݵ�� �����ڰ� �����ؾ� �Ѵ�
			System.out.println("������� => catch���� �������� �ʴ´�");
		}
		// RuntimeException ���� : ����� ���� => RuntimeException
		// �ڡڡ� catch���� 1���� ���� => switch, �������ǹ��� ���
		catch(ArrayIndexOutOfBoundsException e)
		{ // �迭 ������ �ʰ� ���� ��츸 ����
			System.out.println("�迭 ���� �ʰ� ���� �߻�");
		}catch(ArithmeticException e) 
		{ // 0���� ���� ��츸 ����
			System.out.println("0���� ���� �� ����");
		}catch(NumberFormatException e)
		{ // ���ڿ��� ���������� ������ �ȵ� ���, "aaa","A" �Ұ��� / "30" ����
            System.out.println("���� ��ȯ�� �ȵǴ� ����");  
		}catch(NullPointerException e)
		{ // ��ü�ּҳ� �迭�� �ּҰ� ���� ���
			System.out.println("��ü�� �迭�� �ּҰ� ���� ����");
		}
		catch(ClassCastException e)
		{ // Ŭ���� ����ȯ ����
			System.out.println("Ŭ���� ����ȯ ���� �߻�");
		}
		
		catch(RuntimeException e)
		{ // ��Ÿ ���� (������ ���� ������ ó��) - ��� ������ ó���� �� �ִ� Ŭ�����̹Ƿ� �� �ؿ� ����Ѵ�
			System.out.println("��Ÿ ���� ó��");
		}
		System.out.println("���α׷� ����");
	}

}
