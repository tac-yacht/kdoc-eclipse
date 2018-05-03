package com.iyher.eclipse.kdoc

import org.jetbrains.kotlin.ui.editors.hover.KotlinEditorTextHover
import org.eclipse.jface.text.IInformationControlCreator
import org.jetbrains.kotlin.kdoc.lexer.KDocTokens
import org.jetbrains.kotlin.ui.editors.KotlinEditor
import org.jetbrains.kotlin.ui.editors.hover.HoverData
import com.intellij.lang.ASTNode
import com.intellij.psi.tree.TokenSet
import org.jetbrains.kotlin.kdoc.parser.KDocElementTypes

class KDocHover : KotlinEditorTextHover<String> {
	override fun isAvailable(hoverData: HoverData): Boolean {
		val node = getDocNode(hoverData)
		node?.let {
			return true;
		}
		return false
	}

	override fun getHoverInfo(hoverData: HoverData): String? {
		val kDocRoot = getDocNode(hoverData)!!
		//already checked by KotlinEditorTextHover

		val kDocSection = kDocRoot.findChildByType(KDocElementTypes.KDOC_SECTION)
		kDocSection?.let {
			val kDocSectionChildren = kDocSection.getChildren(TokenSet.ANY)
			val textNodes = kDocSectionChildren.filter({node -> KDocTokens.TEXT.equals(node.elementType)})

			return hoverData.component1().getName() + "<br>" + textNodes.joinToString(separator = "", transform = ASTNode::getText)
		}
		return "plugin output: not found"

	}

	override fun getHoverControlCreator(editor: KotlinEditor): IInformationControlCreator? {
		return null
	}

	private fun getDocNode(hoverData: HoverData): ASTNode? {
		return hoverData.component1().getNode().findChildByType(KDocTokens.KDOC)
	}

}