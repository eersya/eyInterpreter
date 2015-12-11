#include <string.h>
#include <stdlib.h>
#include <math.h>
#include <stdio.h>
#include "string_operations.h"

char *sub_string(char *src, const unsigned int begin_index, const unsigned int end_index)
{

  /*
   * If begin_index is equal to end_index, we only need to return a char.
   */
  if(begin_index == end_index) {
    return (char *) src[begin_index]; // or end_index
  } 
  
  /*
   * If the addition of begin_index and end_index equals the length of src,
   * the substring doesn't exist.
   */
  if((begin_index > strlen(src)) || (end_index > strlen(src))) {
    return NULL;
  }

  const int size_subs = (int) sqrt((begin_index * begin_index) + (end_index * end_index)) + 1;
  
  /*
   * Some memory for the string.
   */
  char *substring = malloc(size_subs);
  
  int i = begin_index;
  int subs_counter = 0;
  do {
    
    substring[subs_counter] = src[i];

    if(begin_index < end_index) {
      i++;
    } else {
      i--;
    }
    
    subs_counter++;
  } while(i <= end_index);

  substring[end_index - 1] = '\0'; // The last char of the new string
  
  return substring;
}

int exists_x_char(char *str, const char x)
{
  int times = 0;
  int i = 0;
  const int len = strlen(str);
  for(i = 0; i < len; i++) {
    if(str[i] == x)
      times++;
  }
  return times;
}
