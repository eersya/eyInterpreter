#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include "algebra.h"
#include "string_operations.h"

char *get_coefficient(char *str)
{
  int len = strlen(str);

  short int sign = 1;

  int begin_index = 0;
  int end_index = len;
  
  int i = 0;
  for(i = 0; i < len; i++) {
    if(str[i] == NEGATIVE_SIGN)
      sign *= NEGATIVE;
    if(isalpha(str[i])) {
      begin_index = i;
    }
  }
}

int main()
{
  printf("put a string: ");
  char str[30];
  scanf("%s", str);
  char *sub;
  sub = sub_string(str, 2, 4);
  printf("2 to 4: %s\n", sub);
  return 0;
}
