data Tree = Nil | Node Int Tree Tree deriving Show

--a)
foldTree :: (Int -> a -> a -> a) -> a -> Tree -> a
foldTree _ c Nil = c
foldTree f c (Node v l r) = f v (foldTree f c l) (foldTree f c r)
--b)
sumTree'' :: Tree -> Int
sumTree'' tree = foldTree (sumN) (0) (tree)
sumN = \v l r -> v + l + r

decTree'' :: Tree -> Tree
decTree'' tree = foldTree (decN) (Nil) (tree)
decN = \v l r -> Node (v - 1) l r

flattenTree'' :: Tree -> [Int]
flattenTree'' tree = foldTree (flattenN) ([]) (tree)
flattenN = \v l r -> v : l ++ r

--c)
incTree :: Tree -> Tree
incTree tree = foldTree (incN) (Nil) (tree)
incN = \v l r -> Node (v + 1) l r

--d)
mirror :: Tree -> Tree
mirror tree = foldTree (mirN) (Nil) (tree)
mirN = \v l r -> Node v r l