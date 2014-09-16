// ���������� 1.20.
// �������� ��������� detab, ���������� ������� ��������� �� �������� ������
// ������ ������ �������� (�� ���������� "�����" ���������). ��������������,
// ��� "�����" ��������� ����������� �� ������������� ���������� ���� ��
// �����, ������, ����� n �������.

#include <stdio.h>
#include <stdlib.h>

#define N       4 // ������ "�����" ���������
#define MAXLINE 30 // ������������ ����� ��������� ������

char text[MAXLINE];

int tabreplace (char text[], int j);

int main()
{
    int i = 0;
    char c;
    while ((c = getchar()) != EOF && i < MAXLINE)
        if (c == '\t')
            i = tabreplace(text,i);
        else
        {
            text[i] = c;
            i++;
        }
    printf("%s", text);
    return 0;
}

int tabreplace (char text[], int j)
{
    int start, i = 1;
    if ((j%N) != 0){
        start = 0;
        while ((j%N) != 0)
        {
            text[j] = ' ';
            j++;
        }
    }
    else if (start)
        for (i = 0; i < N; i++) {
            text[j] = ' ';
            j++;
    }
    return j;
}
