package com.iyher.eclipse.kdoc

import org.jetbrains.kotlin.ui.editors.hover.KotlinEditorTextHover
import org.eclipse.jface.text.IInformationControlCreator;
import org.jetbrains.kotlin.kdoc.lexer.KDocTokens;
import org.jetbrains.kotlin.ui.editors.KotlinEditor;
import org.jetbrains.kotlin.ui.editors.hover.HoverData;
import com.intellij.lang.ASTNode

class KDocHover : KotlinEditorTextHover<String> {
	override fun isAvailable(hoverData: HoverData): Boolean {
		var node = getDocNode(hoverData)
		node?.let {
			return true;
		}
		return false
	}

	override fun getHoverInfo(hoverData: HoverData): String? {
		return "plugin output:" + hoverData.component1().getName()
	}

	override fun getHoverControlCreator(editor: KotlinEditor): IInformationControlCreator? {
		return null
	}

	private fun getDocNode(hoverData: HoverData): ASTNode? {
		return hoverData.component1().getNode().findChildByType(KDocTokens.KDOC)
	}

}