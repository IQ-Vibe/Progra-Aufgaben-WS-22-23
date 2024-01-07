import Prelude
import Text.Show.Functions

-- a)
data Knoten = Bool deriving Show
data Blatt = Char deriving Show
data BinTree a b = Blatt b | Knoten a (BinTree a b) (BinTree a b) deriving Show 

-- b)
example :: BinTree (Int -> Bool) Char
example = Knoten (\x -> x > 4) (Knoten (\x -> x * x == x) (Blatt 'g') (Blatt 'u')) (Knoten (\x -> x >= 7) (Knoten (\x -> x == 0) (Blatt 'l') (Blatt 'f')) (Blatt 'i'))

-- c)
countInnerNodes :: BinTree a b -> Int
countInnerNodes (Knoten _ left right ) = 1 + countInnerNodes left + countInnerNodes right
countInnerNodes (Blatt _) = 0

-- d)
