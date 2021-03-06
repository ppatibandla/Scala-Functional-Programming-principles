package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if((c == 0) || (c == r))  1
      else pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def do_balance(rem: List[Char], cur_open : Int) : Boolean = {
          if (cur_open < 0) false
          else if (rem.isEmpty) cur_open==0
          else if(rem.head == '(') do_balance(rem.tail, cur_open+1)
          else if(rem.head == ')') do_balance(rem.tail, cur_open-1)
          else do_balance(rem.tail, cur_open)
      }
      do_balance(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money < 0) 0
      else if (money == 0) 1
      else if (coins.isEmpty) 0
      else countChange(money-coins.head, coins) + countChange(money, coins.tail)
    }
  }
